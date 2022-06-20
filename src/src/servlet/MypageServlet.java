package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		request.setCharacterEncoding("UTF-8");
		LoginUser user = new LoginUser();
		user = (LoginUser)session.getAttribute("id");
		String user_name = user.getId();

		UserDao Dao = new UserDao();
		ArrayList<User> userList =Dao.select(user_name);

		request.setAttribute("userList", userList);

		// マイメニュー画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
}