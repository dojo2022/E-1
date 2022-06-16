package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchResultServlet
 */
@WebServlet("/SearchResultServlet")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultServlet() {
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

		//���r���[�e�[�u������f�[�^���擾
		/*ReviewDao RDao = new ReviewDao();
		List<Review> review_list = RDao.revselect();

		request.setAttribute("review_list", review_list);
		*/
		//���C�ɓ��胆�[�U�ꗗ�y�[�W�Ƀt�H���[�h����
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���������O�C�����Ă��Ȃ������烍�O�C���T�[�u���b�g�Ƀ��_�C���N�g����
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}*/

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
		ReviewDao RDao = new ReviewDao();
		List<Review> review_list = RDao.revselect(new Review(review_id, user_name, nickname,genre_id,review_day,title,series_name,thought,evolition,good,address,url,product_name,price,product_detail));

		// �������ʂ����N�G�X�g�X�R�[�v�Ɋi�[����
		request.setAttribute("review_list", review_list);
*/
		// ���ʃy�[�W�Ƀt�H���[�h����
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review_detail.jsp");
		dispatcher.forward(request, response);

	}

}