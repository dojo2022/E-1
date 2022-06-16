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
		// ���������O�C�����Ă��Ȃ������烍�O�C���T�[�u���b�g�Ƀ��_�C���N�g����
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}*/

		//���C�ɓ��胆�[�U�e�[�u������f�[�^���擾
		/*Favorite_ReviewerDao FUDao = new Favorite_ReviewerDao();
		List<Favorite_Reviewer> faorite_user_list = FUDao.favuserselect();

		request.setAttribute("faorite_user_list", faorite_user_list);
		*/
		//���C�ɓ��胆�[�U�ꗗ�y�[�W�Ƀt�H���[�h����
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
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

		// ���N�G�X�g�p�����[�^���擾����
		/*
		request.setCharacterEncoding("UTF-8");
		String review_id = request.getParameter("${e.review_id}");
		String user_name = request.getParameter("NAME");
		String nickname = request.getParameter("ADDRESS");
		String genre_id = request.getParameter("CNAME");
		String review_day = request.getParameter("DEPARTMENT");
		String title = request.getParameter("URL");
		String series_name = request.getParameter("EMAIL");
		String thought = request.getParameter("TEL");
		String evolition = request.getParameter("CNAME");
		String good = request.getParameter("DEPARTMENT");
		String address = request.getParameter("URL");
		String url = request.getParameter("EMAIL");
		String product_name = request.getParameter("TEL");
		String price = request.getParameter("DEPARTMENT");
		String product_detail = request.getParameter("URL");

		// �����������s��
		UserDao UDao = new UserDao();
		List<User> user_list = UDao.userselect(new Review(review_id, user_name, nickname,genre_id,review_day,title,series_name,thought,evolition,good,address,url,product_name,price,product_detail));

		// �������ʂ����N�G�X�g�X�R�[�v�Ɋi�[����
		request.setAttribute("review_list", review_list);
*/
		// ���ʃy�[�W�Ƀt�H���[�h����
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_detail.jsp");
		dispatcher.forward(request, response);

		/*
		request.setCharacterEncoding("UTF-8");
		String reviewer_profile = request.getParameter("${e.reviewer_profile}");

		Favorite_ReviewerDao FUDao = new Favorite_ReviewerDao();
		if (request.getParameter("follow_state").equals("���C�ɓ������")) {
			if (FUDao.delete(reviewer_profile)) {
			}
		}
		//���C�ɓ��胆�[�U�ꗗ�y�[�W�ɖ߂�
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/favorite_user_list.jsp");
		dispatcher.forward(request, response);
		*/
	}

}
