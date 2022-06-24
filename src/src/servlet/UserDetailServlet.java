package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Favorite_GenreDao;
import dao.Favorite_ReviewerDao;
import dao.ReviewDao;
import dao.TitleDao;
import dao.UserDao;
import model.LoginUser;
import model.Review;
import model.Title;
import model.User;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		//
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//*/
		/*ユーザ名の取得
		 *review_idをセッションスコープから取得
		 *取得したreview_idからuser_name(id)を取得
		 *取得してidからuser情報を取得
		*/

		request.setCharacterEncoding("UTF-8");
		int review_id =  1;  //(int)session.getAttribute("review_id");//
		ReviewDao RDao = new ReviewDao();
		List<Review> reviewList  = RDao.select(new Review(review_id));

		//取得したユーザIdを格納する変数
		String others_id ="";//others.getId();

		for(Review review : reviewList ){
			others_id = review.getUser_name();
		}

		//others_idに該当するレコードを検出する。
		UserDao UDao = new UserDao();
		List<User> userList = UDao.select(others_id);

		User user = new User();

		for(User user2 : userList){
			user.setId(user2.getId());
			user.setUser_image(user2.getUser_image());
			user.setC_public(user2.getC_public());
		}

		if(user.getUser_image() == null){
			user.setUser_image("icon_panda.png");
		}

		request.setAttribute("user", user);

		//ユーザの累計いいね数を取得し、その数値あった称号を与える
		/*
		 * レビューテーブルからユーザIDに合致する投稿Listを取得
		 * 取得したListからいいね数を抽出、合計を求める
		 * 求めた合計を称号テーブルに渡し、該当する称号を取得する。*/
		TitleDao TDao = new TitleDao();

		int total_good  = TDao.totalgood(others_id);

		request.setAttribute("total_good", total_good);

		Title title = TDao.select(total_good);

		request.setAttribute("title", title);

		//login_user_idのお気に入りジャンルの取得
		Favorite_GenreDao FGDao = new Favorite_GenreDao();

		ArrayList<String> FGList = FGDao.select(others_id);

		request.setAttribute("FGList", FGList);

		//他ユーザ詳細画面にフォワードする
		//UserIDを取得 アイコン、名前、称号、お気に入り投稿、お気に入りジャンル累計いいね数、最新投稿、
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_detail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		HttpSession session = request.getSession(); //リクエストを受けるのに必須
		//
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}//*/
		//ログインユーザ名の取得
		request.setCharacterEncoding("UTF-8");
		LoginUser login_user = new LoginUser();
		login_user = (LoginUser)session.getAttribute("id");
		String login_user_id = login_user.getId();//"tanaka";

		/*ユーザ名の取得
		 *review_idをセッションスコープから取得
		 *取得したreview_idからuser_name(id)を取得
		 *取得してidからuser情報を取得*/
		int review_id = (int)session.getAttribute("review_id");
		ReviewDao RDao = new ReviewDao();
		List<Review> reviewList  = RDao.select(new Review(review_id));

		//取得したユーザIdを格納する変数
		String others_id ="";// "tanaka";//others.getId();

		for(Review review : reviewList ){
			others_id = review.getUser_name();
		}

		//お気に入りユーザに登録
		Favorite_ReviewerDao FRerDao = new Favorite_ReviewerDao();

		if(!FRerDao.insert(login_user_id, others_id)) {
			session.setAttribute("FavoriteRegisterMassage","followed");
		}
		else{
			session.setAttribute("FavoriteRegisterMassage","follow");

		}
		//他ユーザ詳細画面にフォワードする
		doGet(request, response);
	}
}
