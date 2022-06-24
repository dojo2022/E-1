package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import model.Review_List;
/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				System.out.print("doGet");
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			/*	HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/dokogacha/LoginServlet");
					return;
				}*/

		        request.setCharacterEncoding("UTF-8");
		        ReviewDao rDao = new ReviewDao();
		        int review_id = rDao.TRselect();
		        ReviewDao uDao = new ReviewDao();
				List<Review_List> trend_review = uDao.Tselect(review_id);
				request.setAttribute("trend_review", trend_review);


				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
				dispatcher.forward(request, response);
	}
	    /*doPost( request , respo
		return;
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// トップページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
				dispatcher.forward(request, response);

	}
}