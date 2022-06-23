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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int review_id = (int) session.getAttribute("review_id");
		System.out.println(review_id);
			ReviewDao rDao = new ReviewDao();
		List<Review> review_detailList = rDao.select(new Review(review_id));
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
		HttpSession session = request.getSession();
		int review_id = (int) session.getAttribute("review_id");
		boolean goodcount;
		ReviewDao rDao = new ReviewDao();
		if (request.getParameter("goodbutton").equals("いいねボタン")) {
			 goodcount = rDao.goodcount(new Review(review_id));
/*
		} else if (request.getParameter("favoritebutton").equals("お気に入りボタン")){
			rDao.favoriteregist(review_id) ;
		} else {
			List<Review> review_detailList = rDao.select(new Review(review_id));
			request.setAttribute("review_detailList", review_detailList);
			*/

			// レビュー詳細ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review_detail.jsp");
			dispatcher.forward(request, response);
		}
	}
}