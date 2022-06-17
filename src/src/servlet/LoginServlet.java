package servlet;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IdpwDao;
import model.Idpw;
import model.LoginUser;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		byte[] cipher_byte;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			cipher_byte=md.digest();
			StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
			for(byte b: cipher_byte) {
				sb.append(String.format("%02x", b&0xff));
			}
			pw = sb.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}

	IdpwDao iDao = new IdpwDao();
	if(iDao.isLoginOK(new Idpw(id,pw))) {
		HttpSession session = request.getSession();
		session.setAttribute("id", new LoginUser(id));
		response.sendRedirect("/dokogacha/TopServlet");
	}
	else {
		request.setAttribute("error_message","ユーザ名またはパスワードが間違っています。");
	}
}
}
