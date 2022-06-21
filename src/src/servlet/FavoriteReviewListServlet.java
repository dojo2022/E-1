package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Favorite_ReviewDao;
import model.Review_List;
/**
 * Servlet implementation class FavoriteReviewListServlet
 */
@WebServlet("/FavoriteReviewListServlet")
public class FavoriteReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}*/

		/*
		LoginUser LU = new LoginUser();
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter(LU.getId());
		*/


		Favorite_ReviewDao FRDao = new Favorite_ReviewDao();
		List<Review_List> favorite_review_list = FRDao.favrevselect("yamada");

		request.setAttribute("favorite_review_list", favorite_review_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_review_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}*/
		/*
		request.setCharacterEncoding("UTF-8");
		String review_id = request.getParameter("${e.review_id}");

		request.setAttribute("review_id", review_id);
*/

		RequestDispatcher dispatcher = request.getRequestDispatcher("/dokogacha/ReviewDetailServlet");
		dispatcher.forward(request, response);
		/*
		request.setCharacterEncoding("UTF-8");
		String review_id = request.getParameter("${e.review_id}");

		Favorite_ReviewerDao FRDao = new Favorite_ReviewerDao();
		if (request.getParameter("follow_state").equals("お気に入り解除")) {
			if (FRDao.delete(review_id)) {
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
		dispatcher.forward(request, response);
		*/
	}

}
