package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Favorite_GenreDao;
import dao.TitleDao;
import dao.UserDao;
import model.LoginUser;
import model.Title;
import model.User;

/**
 *1.マイページへの遷移 LoginUserのUser_Idを入手し、ログイン状態を判定
 * ->ログインしていなければログインページへリダイレクトさせる
 *2.Userテーブルからuser_Idに該当するレコードを取得
 *3.Fテーブルからuser_Idに該当するレコードを取得

 */
@MultipartConfig(location = "C:/dojo6/src/WebContent/img/user_image")
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("DoGet");
		HttpSession session = request.getSession(); //リクエストを受けるのに必須
		///*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//*/
		//ログインユーザ名の取得
		request.setCharacterEncoding("UTF-8");
		LoginUser login_user = new LoginUser();
		login_user = (LoginUser)session.getAttribute("id");
		String login_user_id = login_user.getId(); //"DOJO"; //

		//user_nameに該当するレコードを検出する。
		UserDao UDao = new UserDao();
		List<User> userList = UDao.select(login_user_id);

		User user = new User();

		for(User user2 : userList){
			user.setId(user2.getId());
			user.setUser_image(user2.getUser_image());
			user.setC_public(user2.getC_public());
		}
		String user_image =user.getUser_image();

		System.out.println("User_image" + user.getUser_image());
		System.out.println("public" + user.getC_public());

		//ユーザアイコンがセットされていない場合
		if(user.getUser_image() == null){
			System.out.println(user_image);
			user.setUser_image("icon_panda.png");
		}

		request.setAttribute("user", user);

		//ユーザのいいね数を調べてその数値あった称号を与える
		/*工程
		 * レビューテーブルからユーザIDに合致する投稿Listを取得
		 * 取得したListからいいね数を抽出、合計を求める
		 * 求めた合計を称号テーブルに渡し、該当する称号を取得する。
		 */
		TitleDao TDao = new TitleDao();

		int total_good  = TDao.totalgood(login_user_id);

		request.setAttribute("total_good", total_good);

		Title title = TDao.select(total_good);

		request.setAttribute("title", title);

		//login_user_idのお気に入りジャンルの取得
		Favorite_GenreDao FGDao = new Favorite_GenreDao();

		ArrayList<String> FGList = FGDao.select(login_user_id);

		request.setAttribute("FGList", FGList);

		// マイメニュー画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
	/*-------------doPost-----------------------------------------------------------------*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request,response );
	}
	/*-------------end class-----------------------------------------------------------------*/
}



