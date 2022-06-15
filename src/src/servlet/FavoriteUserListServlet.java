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
		/*Favorite_ReviewerDao FRDao = new Favorite_ReviewerDao();
		List<FavUser> faorite_user_list = FRDao.favuserselect();
		
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
		/*
		request.setCharacterEncoding("UTF-8");
		String reviewer_profile = request.getParameter("${e.reviewer_profile}");
		
		Favorite_ReviewerDao FRDao = new Favorite_ReviewerDao();
		if (request.getParameter("SUBMIT").equals("�X�V")) {
			if (bDao.update(new Bc(number, name, address,cname,department,url,email,tel))) {	// �X�V����
				request.setAttribute("result",
				new Result("�X�V�����I", "���R�[�h���X�V���܂����B", "/simpleBC/MenuServlet"));
			}
			else {												// �X�V���s
				request.setAttribute("result",
				new Result("�X�V���s�I", "���R�[�h���X�V�ł��܂���ł����B", "/simpleBC/MenuServlet"));
			}
		}*/
	}

}
