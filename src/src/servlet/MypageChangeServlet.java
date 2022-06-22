package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.UserDao;
import model.LoginUser;
import model.User;

/**
 *1.マイページ変更画面への遷移 LoginUserのUser_Idを入手し、ログイン状態を判定
 *→ログインしていなければログインページへリダイレクトさせる
 *
 */
//↓アップロードファイルの一時的な保存先
@MultipartConfig(location = "C:/dojo6/src/WebContent/img/user_image")
@WebServlet("/MypageChangeServlet")
public class MypageChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//
		/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//*/
		//ログイン中のゆーざIDを取得
		request.setCharacterEncoding("UTF-8");
		LoginUser LoginUser = new LoginUser();
		LoginUser = (LoginUser)session.getAttribute("id");
		String LoginUserId = "tanaka";//loginuser.getId();

		//user_nameに該当するレコードを検出する。
		UserDao UDao = new UserDao();
		List<User> userList = UDao.select(LoginUserId);

		User user = new User();

		for(User user2 : userList){
			user.setId(user2.getId());
			user.setUser_image(user2.getUser_image());
			user.setC_public(user2.getC_public());
			//System.out.println(user2.getId() +":"+ user2.getUser_image() +":"+ user2.getC_public());
		}
		String image = user.getUser_image();
		//ユーザアイコンがセットされていない場合
		if(image.equals("")) {
			user.setUser_image("icon_panda.png");
		}

		request.setAttribute("user", user);


		//マイページ変更画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage_change.jsp");
		dispatcher.forward(request, response);
	}

	/*--doPost----------------------------------------------------------------*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
		{
			HttpSession session = request.getSession();
			//
			/*
			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/dokogacha/LoginServlet");
				return;
			}
			//*/
			//ログイン中のゆーざIDを取得
			request.setCharacterEncoding("UTF-8");
			LoginUser LoginUser = new LoginUser();
			LoginUser = (LoginUser)session.getAttribute("id");
			String LoginUserId = "tanaka";//loginuser.getId();


			//user_nameに該当するレコードを検出する。
			UserDao UDao = new UserDao();
			List<User> userList = UDao.select(LoginUserId);

			User user = new User();

			for(User user2 : userList){
				user.setId(user2.getId());
				user.setUser_image(user2.getUser_image());
				user.setC_public(user2.getC_public());
				//System.out.println(user2.getId() +":"+ user2.getUser_image() +":"+ user2.getC_public());
			}

			String old_image = user.getUser_image();

			String new_id = request.getParameter("user_id");

			String chose_public = request.getParameter("chose_public");

			//ArrayList<String> userchange = new ArrayList<String>(); スコープ渡しのお試し1
			//request.setAttribute("userchange", name); スコープ渡しのお試し2

			//画像関係の処理
			Part part = request.getPart("IMAGE"); // getPartで取得

			String image = this.getFileName(part);

			System.out.println("image"+image);

			if(!image.equals("")){				//アイコンがアップロードされた場合
				part.write(image); 					//アップロードされた画像をディスクに書き込む
			}
			else {
				image = old_image;
			}
			boolean flag =  UDao.update(LoginUserId, new_id, image , chose_public);
			if(flag) {
				// サーバの指定のファイルパスへファイルを保存
				//場所はクラス名↑の上に指定してある


				///*
				//確認セット
				//request.setAttribute("image", image);//確認用
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/upload_result.jsp");
				//dispatcher.forward(request, response);
				//*/
				//「マイメニュー」へのリダイレクト
				response.sendRedirect("/dokogacha/MypageServlet");
			}
			else {
				//マイページ変更画面にフォワードする
				doGet(request,response);
			}
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