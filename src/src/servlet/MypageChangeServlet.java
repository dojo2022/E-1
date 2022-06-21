package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *1.マイページ変更画面への遷移 LoginUserのUser_Idを入手し、ログイン状態を判定
 *→ログインしていなければログインページへリダイレクトさせる
 *
 */
//↓アップロードファイルの一時的な保存先
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\img")
@WebServlet("/MypageChangeServlet")
public class MypageChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//*/





		//マイページ変更画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage_change.jsp");
		dispatcher.forward(request, response);
	}

	/*--doPost----------------------------------------------------------------*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
		{
		//
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//*/

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("user_id");

		String chose_public = request.getParameter("chose_public");



		//ArrayList<String> userchange = new ArrayList<String>(); スコープ渡しのお試し1
		//request.setAttribute("userchange", name); スコープ渡しのお試し2

		//画像関係の処理
		Part part = request.getPart("IMAGE"); // getPartで取得

		String image = this.getFileName(part);

		request.setAttribute("image", image);
		// サーバの指定のファイルパスへファイルを保存
		//場所はクラス名↑の上に指定してある
		part.write(image);
		//「マイメニュー」へのフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/upload_result.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("/dokogacha/MypageServlet");
		}

/*----------------------------------------------------------------------------------------------*/
	//ファイルの名前を取得してくる
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
		return name;
	}

}