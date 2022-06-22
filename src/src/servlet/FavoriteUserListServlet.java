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

import dao.Favorite_ReviewerDao;
import model.LoginUser;
import model.User;


/**
 * Servlet implementation class FavoriteUserListServlet
 */
@WebServlet("/FavoriteUserListServlet")
public class FavoriteUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteUserListServlet() {
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

		//ログイン中のユーザ名を取得
		request.setCharacterEncoding("UTF-8");
		LoginUser loginuser = new LoginUser();
		loginuser = (LoginUser)session.getAttribute("id");
		String user_name = loginuser.getId();

		//ログイン中のユーザ名からお気に入り投稿者を検索してお気に入り投稿者一覧画面へフォワード
		Favorite_ReviewerDao FUDao = new Favorite_ReviewerDao();
		List<User> favorite_user_list = FUDao.favselect(user_name);

		request.setAttribute("favorite_user_list", favorite_user_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
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

		//画面遷移元からお気に入り投稿者のユーザ名を取得してユーザ詳細サーブレットへ
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user");

		request.setAttribute("user_name", user_name);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/dokogacha/UserDetailServlet");
		//dispatcher.forward(request, response);

		//お気に入り解除ぼやんが押されたら
		if (request.getParameter("follow_state").equals("お気に入り解除")) {

			//ログイン中のユーザ名を取得
			request.setCharacterEncoding("UTF-8");
			LoginUser loginuser = new LoginUser();
			loginuser = (LoginUser)session.getAttribute("id");
			String my_name = loginuser.getId();

			//お気に入りユーザ名とログイン中のユーザ名の両方が一致するお気に入り投稿者を削除してリロード
			Favorite_ReviewerDao FRDao = new Favorite_ReviewerDao();
			FRDao.delete(my_name,user_name);

			response.sendRedirect("/dokogacha/FavoriteUserListServlet");
		}
	}
}
