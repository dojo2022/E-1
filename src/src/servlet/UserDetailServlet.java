package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//他ユーザ詳細画面にフォワードする
		//UserIDを取得 アイコン、名前、称号、お気に入り投稿、お気に入りジャンル累計いいね数、最新投稿、




		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_detail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		//お気に入りユーザに登録


		//他ユーザ詳細画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_detail.jsp");
		dispatcher.forward(request, response);
	}
}
