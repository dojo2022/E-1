package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// ���������O�C�����Ă��Ȃ������烍�O�C���T�[�u���b�g�Ƀ��_�C���N�g����
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}*/

		//���C�ɓ��蓊�e�e�[�u������f�[�^���擾
		/*Favorite_ReviewDao FRDao = new Favorite_ReviewDao();
		List<Favorite_Review> faorite_review_list = FRDao.favrevselect();

		request.setAttribute("faorite_review_list", faorite_review_list);
		*/
		//���C�ɓ��胆�[�U�ꗗ�y�[�W�Ƀt�H���[�h����
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_review_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���������O�C�����Ă��Ȃ������烍�O�C���T�[�u���b�g�Ƀ��_�C���N�g����
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
		/*
		request.setCharacterEncoding("UTF-8");
		String review_id = request.getParameter("${e.review_id}");

		Favorite_ReviewerDao FRDao = new Favorite_ReviewerDao();
		if (request.getParameter("follow_state").equals("���C�ɓ������")) {
			if (FRDao.delete(review_id)) {
			}
		}
		//���C�ɓ��胆�[�U�ꗗ�y�[�W�ɖ߂�
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
		dispatcher.forward(request, response);
		*/
	}

}
