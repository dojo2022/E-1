package servlet;

import java.io.File;
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
		System.out.println("DoGet_MypageChangeServlet");
		HttpSession session = request.getSession();
		///*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//*/
		//ログイン中のユーザIDを取得
		request.setCharacterEncoding("UTF-8");
		LoginUser login_user = new LoginUser();
		login_user = (LoginUser)session.getAttribute("id");
		String login_user_id = login_user.getId();

		//user_nameに該当するレコードを検出する。
		UserDao UDao = new UserDao();
		List<User> userList = UDao.select(login_user_id);

		User user = new User();

		for(User user2 : userList){
			user.setId(user2.getId());
			user.setUser_image(user2.getUser_image());
			user.setC_public(user2.getC_public());
		}
		//ユーザアイコンがセットされていない場合
		if(user.getUser_image() == null) {
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
			System.out.println("DoPost_MypageChangeServlet");
			HttpSession session = request.getSession();
			///*
			// もしもログインしていなかったらログインサーブレットにリダイレクトする
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/dokogacha/LoginServlet");
				return;
			}
			//*/
			//ログイン中のユーザIDを取得
			request.setCharacterEncoding("UTF-8");
			LoginUser login_user = new LoginUser();
			login_user = (LoginUser)session.getAttribute("id");
			String login_user_id = login_user.getId();


			//user_nameに該当するレコードを検出する。
			UserDao UDao = new UserDao();
			List<User> userList = UDao.select(login_user_id);

			User user = new User();

			for(User user2 : userList){
				user.setId(user2.getId());
				user.setUser_image(user2.getUser_image());
				user.setC_public(user2.getC_public());
			}
			//登録情報、入力情報の取得
			String old_image = user.getUser_image();
			String new_id = request.getParameter("user_id");
			String chose_public = request.getParameter("chose_public");

			//アイコンが未設定の場合の処理
			if( old_image == null){
				old_image = "icon_panda.png";
			}

			//画像関係の処理
			Part part = request.getPart("IMAGE"); // getPartで取得

			String new_image = this.getFileName(part);

			File file = new File("C:/dojo6/src/WebContent/img/user_image/"+new_image);//絶対パス出ないとダメそう

			if (new_image.equals("")){
				//アイコン画像ファイルが変更されなかった場合
				new_image = old_image;
			}
			else if(file.exists()) {
				// アイコン画像ファイルが存在している場合
				System.out.println(new_image+" has already been uploaded");
			}
			else{
				// ファイルが存在していない場合
				// サーバの指定のファイルパスへファイルを保存
				//場所はクラス名↑の上に指定してある
				part.write(new_image);//アップロードされた画像をディスクに書き込む
			}

			if(UDao.update(login_user_id, new_id, new_image , chose_public)) {
				//5秒待つ→アップロードに時間がかかるため
	      try {
	          Thread.sleep( 5 * 1000 );
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
	  		session.setAttribute("id", new LoginUser(new_id));
				//「マイメニュー」へのリダイレクト
				response.sendRedirect("/dokogacha/MypageServlet");
			}
			else {
				//マイページ変更画面にフォワードする
				doGet(request,response);
			}
		}

/*----------------------------------------------------------------------------------------------*/
	//ファイルの名前を取得してくる　パスはここで分離される。
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