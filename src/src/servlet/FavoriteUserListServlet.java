package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Favorite_ReviewerDao;
import model.User;


/**
 * Servlet implementation class FavoriteUserListServlet
 */
@WebServlet("/FavoriteUserListServlet")
public class FavoriteUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteUserListServlet() {
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

		Favorite_ReviewerDao FUDao = new Favorite_ReviewerDao();
		List<User> favorite_user_list = FUDao.favselect("maura");

		request.setAttribute("favorite_user_list", favorite_user_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
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
		String reviewer_id = request.getParameter("${e.id}");

		Favorite_ReviewerDao FUDao = new Favorite_ReviewerDao();
		if (request.getParameter("follow_state").equals("お気に入り解除")) {
			if (FUDao.delete(reviewer_id)) {
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
		dispatcher.forward(request, response);
		*/
	}
}
