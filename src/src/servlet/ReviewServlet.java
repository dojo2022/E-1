package servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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

import dao.GenreDao;
import dao.ReviewDao;
import dao.Review_ImageDao;
import model.Genre;
import model.LoginUser;
import model.Review;
import model.Review_Image;


//↓アップロードファイルの一時的な保存先
@MultipartConfig(location = "C:/dojo6/src/WebContent/img")
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// レビュー投稿ページにフォワードする
		// 検索処理を行う
		GenreDao gDao = new GenreDao();
		List<Genre> genreList = gDao.select(); //改造する

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("genreList", genreList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginUser user = new LoginUser();
		//ログインしていない場合の処理
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/dokogacha/LoginServlet");
			return;
		}
		//５段階評価が入力されていない場合の処理
		int star;
		String star_Str = request.getParameter("star");
		if( star_Str== null|| star_Str == "") {
			star = 1;
		}else {
			star = Integer.parseInt(request.getParameter("star"));
		}
		//金額が入力されていない場合の処理
		int price = 0;
		String price_Str = request.getParameter("price");
		if( price_Str.equals("")) {
			price = 0;
		}else if(!price_Str.chars().allMatch(Character::isDigit)){
			request.setAttribute("error_message","※金額は数値のみ入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
			dispatcher.forward(request, response);
		}		else {
			price = Integer.parseInt(request.getParameter("price"));
		}

		user = (LoginUser)session.getAttribute("id");
		int genre_id = Integer.parseInt(request.getParameter("genre"));
		int good = 0;
		String user_name = user.getId();
		String product_name = request.getParameter("product_name");
		String title = request.getParameter("title");
		String series = request.getParameter("series");
		String thought = request.getParameter("thought");
		String address = request.getParameter("address");
		//String image = request.getParameter("insert_image");
		ReviewDao rDao = new ReviewDao();
		Review_ImageDao riDao = new Review_ImageDao();

		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date now = new Date();
		String review_day = f.format(now);


		//画像関係の処理
		String[] images = new String[4];
		Collection<Part> parts = request.getParts();
		Part[] parts_image = new Part[4];

		int i = 0;
		for(Part part : parts) {
			if(part.getName().equals("insert_image")) {
				images[i] = this.getFileName(part);
				parts_image[i] = part;
				//ファイルが存在しているか確かめる処理
				File file = new File("C:/dojo6/src/WebContent/img/"+images[i]);//絶対パス出ないとダメそう

				if(file.exists()) {
					// アイコン画像ファイルが存在している場合
					System.out.println(images[i]+" has already been uploaded");
				}
				else{
					// ファイルが存在していない場合
					// サーバの指定のファイルパスへファイルを保存
					//場所はクラス名↑の上に指定してある
					parts_image[i].write(images[i]);//アップロードされた画像をディスクに書き込む
				}
				i++;
			}
		}

		//金額に文字が入力されていた場合のエラー処理
		//正常に動作した場合の処理
		if(rDao.insert(new Review(0,user_name, genre_id, review_day, title, series, thought, star, good, address, product_name, price))){
			int rev_id = rDao.rev_id();
			System.out.println(rev_id);
			boolean flag = false;
			for(String image : images){
			if(!(image == null)) {
			System.out.println(image);
			//rDaoにて、review_imageを追加
			flag = riDao.insert_image(new Review_Image(rev_id,image));
			}
			else {
				break;
			}
			}
			if(flag){
				response.sendRedirect("/dokogacha/ReviewResultServlet");
			}
			else {
				request.setAttribute("error_message","※入力に誤りがあります。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
				dispatcher.forward(request, response);
			}
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
