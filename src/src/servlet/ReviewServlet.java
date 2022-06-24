package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import model.LoginUser;
import model.Review;
import model.Review_Image;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// レビュー投稿ページにフォワードする
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
			star = 0;
		}else {
			star = Integer.parseInt(request.getParameter("star"));
		}
		//金額が入力されていない場合の処理
		int price;
		String price_Str = request.getParameter("price");
		if(price_Str == null || price_Str == "") {
			price = 0;
		}else {
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
		/*if( price_Str.equals("") || price_Str == null ){
			price = 0;
		}*/
		/*else if( !price_Str.chars().allMatch( Character::isDigit) ){
			//		↑id_Strに文字が含まれているか判定する(文字が含まれるとFalseを返す)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else{
			price = Integer.parseInt(price_Str);
		}
		 */
		SimpleDateFormat f =
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date now = new Date();
		String review_day = f.format(now);

		ReviewDao rDao = new ReviewDao();

		//金額に文字が入力されていた場合のエラー処理
		if(!price_Str.chars().allMatch(Character::isDigit)){
			request.setAttribute("error_message","※金額は数値のみ入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
			dispatcher.forward(request, response);

		}
		//正常に動作した場合の処理
		else {
			//price = Integer.parseInt(price_Str);
			if(rDao.insert(new Review(0,user_name, genre_id, review_day, title, series, thought, star, good, address, product_name, price))) {
				if(rDao.insert_image(new Review_Image(review_id,image))) {
					response.sendRedirect("/dokogacha/ReviewResultServlet");
					return;
				}
			}
			//rDaoにて、review_imageを追加
		}
	}


}
