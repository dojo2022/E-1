package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import model.Review;

/**
 * Servlet implementation class ReviewDetailServlet
 */
@WebServlet("/ReviewDetailServlet")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}*/
			ReviewDao iDao = new ReviewDao();
		List<Review> review_detailList = iDao.select(new Review(review_id));
		request.setAttribute("review_detailList", review_detailList);

		
		
		// レビュー詳細ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review_detail.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}*/
		request.setCharacterEncoding("UTF-8");
		String review_id = request.getParameter("${e.review_id}");

		ReviewDao FRDao = new ReviewDao();
		if (request.getParameter("goodbutton").equals("いいねボタン")) {
			 FRDao.goodcount(review_id) ;

		} else if (request.getParameter("favoritebutton").equals("お気に入りボタン")){
			FRDao.favoriteregist(review_id) ;
		}
	}
}