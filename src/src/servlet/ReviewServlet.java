package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String product_name = request.getParameter("product_name");
		String title = request.getParameter("title");
		String genre = request.getParameter("genre");
		String series = request.getParameter("series");
		String thought = request.getParameter("thought");
		String price = request.getParameter("price");
		String address = request.getParameter("address");

		ReviewDao iDao = new ReviewDao();
		if(rDao.insert(new Review(product_name, title, genre, series, thought, price, address))) {
			response.sendRedirect("/dokogacha/ReviewResultServlet");
			return;
		}

	}
	*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// レビュー投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
		dispatcher.forward(request, response);
	}
}
