package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Favorite_ReviewDao;
import model.LoginUser;
import model.Review_List;
/**
 * Servlet implementation class FavoriteReviewListServlet
 */
@WebServlet("/FavoriteReviewListServlet")
public class FavoriteReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインしていなければログイン画面へリダイレクト
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}

		//現在ログインしているユーザのユーザ名を取得
		request.setCharacterEncoding("UTF-8");
		LoginUser loginuser = new LoginUser();
		loginuser = (LoginUser)session.getAttribute("id");
		String user_name = loginuser.getId();


		//ログイン中のユーザ名からお気に入り投稿を検索してお気に入り投稿一覧画面へフォワード
		Favorite_ReviewDao FRDao = new Favorite_ReviewDao();
		List<Review_List> favorite_review_list = FRDao.favrevselect(user_name);

		request.setAttribute("favorite_review_list", favorite_review_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_review_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインしていなければログイン画面へリダイレクト
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}

		//画面遷移元からreview_idを取得して投稿詳細サーブレットへ
		request.setCharacterEncoding("UTF-8");
		int review_id = Integer.parseInt(request.getParameter("review_id"));

		request.setAttribute("review_id", review_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/dokogacha/ReviewDetailServlet");
		//dispatcher.forward(request, response);

		//お気に入り解除ボタンが押されたら
		if (request.getParameter("follow_state").equals("お気に入り解除")) {

			//ログイン中のユーザ名を取得
			request.setCharacterEncoding("UTF-8");
			LoginUser loginuser = new LoginUser();
			loginuser = (LoginUser)session.getAttribute("id");
			String my_name = loginuser.getId();

			//review_idとユーザ名の両方が一致するお気に入り投稿を削除してリロード
			Favorite_ReviewDao FRDao = new Favorite_ReviewDao();
			FRDao.delete(my_name,review_id);

			response.sendRedirect("/dokogacha/FavoriteReviewListServlet");
		}

	}

}
