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

import dao.GenreDao;
import dao.ReviewDao;
import model.Genre;
import model.Review_List;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}

		// 検索処理を行う
		GenreDao gDao = new GenreDao();
		List<Genre> genreList = gDao.select(); //改造する

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("genreList", genreList);

		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する 改造する
		request.setCharacterEncoding("UTF-8");
		int genre = Integer.parseInt(request.getParameter("genre"));
		String word = request.getParameter("word");
		String address = request.getParameter("address");

		GenreDao gDao = new GenreDao();
		String genre_name = gDao.GNselect(genre);
		request.setAttribute("genre",genre_name);
		request.setAttribute("word",word);
		request.setAttribute("address",address);

		// 検索処理を行う
		ReviewDao rDao = new ReviewDao();
		List<Review_List> reviewList = rDao.search(genre, word, address); //改造する

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("reviewList", reviewList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
		dispatcher.forward(request, response);
	}
}
