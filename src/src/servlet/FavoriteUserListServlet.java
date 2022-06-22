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

import dao.Favorite_ReviewerDao;
import model.LoginUser;
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
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}

		LoginUser LU = new LoginUser();
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter(LU.getId());


		Favorite_ReviewerDao FUDao = new Favorite_ReviewerDao();
		List<User> favorite_user_list = FUDao.favselect(user_name);

		request.setAttribute("favorite_user_list", favorite_user_list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
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
		String user_name = request.getParameter("user");

		request.setAttribute("user_name", user_name);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/dokogacha/UserDetailServlet");
		dispatcher.forward(request, response);

		if (request.getParameter("follow_state").equals("お気に入り解除")) {

			LoginUser LU = new LoginUser();
			request.setCharacterEncoding("UTF-8");
			String my_name = request.getParameter(LU.getId());

			Favorite_ReviewerDao FRDao = new Favorite_ReviewerDao();
			FRDao.delete(my_name,user_name);

			response.sendRedirect("/dokogacha/FavoriteUserListServlet");
		}
	}
}
