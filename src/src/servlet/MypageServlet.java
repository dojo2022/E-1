package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.LoginUser;
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

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession(); //リクエストを受けるのに必須
		//
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//*/
		//ログインユーザ名の取得
		request.setCharacterEncoding("UTF-8");
		LoginUser loginuser = new LoginUser();
		loginuser = (LoginUser)session.getAttribute("id");
		String loginuser_name = "tanaka";//loginuser.getId();

		//user_nameに該当するレコードを検出する。
		UserDao UDao = new UserDao();
		List<User> userList = UDao.select(loginuser_name);

		User user = new User();

		for(User user2 : userList){
			user.setId(user2.getId());
			user.setUser_image(user2.getUser_image());
			user.setC_public(user2.getC_public());
		}
		request.setAttribute("user", user);
/*
		TitleDao TDao = new TitleDao();
		List<Title> TitleList =TDao.select(loginuser_name);
		Title title =new Title();

		for(Title title2 : TitleList){
			user.setId(title2.getImage());
			}
		request.setAttribute("title", title);
*/
		// マイメニュー画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
}