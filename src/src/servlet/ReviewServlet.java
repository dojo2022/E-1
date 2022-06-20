package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import model.LoginUser;
import model.Review;

/*
import dao.ReviewDao;
import model.Review;
*/

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}*/
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		LoginUser user = new LoginUser();
		user = (LoginUser)session.getAttribute("id");
		String user_name = user.getId();

		String product_name = request.getParameter("product_name");
		String title = request.getParameter("title");
		int genre_id = Integer.parseInt(request.getParameter("genre"));
		String series = request.getParameter("series");
		String thought = request.getParameter("thought");
		String price_Str = request.getParameter("price");
		int price;
		if( price_Str.equals("") || price_Str == null ){
			price = 0;
		}
		else if( !price_Str.chars().allMatch( Character::isDigit) ){
			//		↑id_Strに文字が含まれているか判定する(文字が含まれるとFalseを返す)
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reviw.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else{
			price = Integer.parseInt(price_Str);
		}
		String address = request.getParameter("address");
		String star = request.getParameter("star");
		String insert_image = request.getParameter("insert_image");

		ReviewDao rDao = new ReviewDao();
		if(rDao.insert(new Review("",user_name, genre_id, product_name, title, genre, series, thought, price, address, star, insert_image))) {
			response.sendRedirect("/dokogacha/ReviewResultServlet");
			return;
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// レビュー投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
		dispatcher.forward(request, response);
	}
}
