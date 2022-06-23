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
import model.LoginUser;
import model.Review_List;

/**
 * Servlet implementation class MyReviewListServlet
 */
@WebServlet("/MyReviewListServlet")
public class MyReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}



		request.setCharacterEncoding("UTF-8");
		LoginUser loginuser = new LoginUser();
		loginuser = (LoginUser)session.getAttribute("id");
		String user_name = loginuser.getId();


		ReviewDao uDao = new ReviewDao();
		List<Review_List> my_review_list = uDao.URselect("pooh");
		request.setAttribute("my_review_list", my_review_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/my_review_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		int review_id = Integer.parseInt(request.getParameter("review_id"));

		request.setAttribute("review_id", review_id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/dokogacha/ReviewDetailServlet");
		//dispatcher.forward(request, response);


	}

}
