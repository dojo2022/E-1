package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;
import model.Review_List;

//--------------------------------------------------------------------------------------------
//search文
public class ReviewDao {
	//↓↓searchメソッドの作成開始
	public List<Review_List> search(int genre, String word, String address){
		List<Review_List> reviewList = new ArrayList<Review_List>();
		Connection conn = null;  //DBと接続するメソッドを宣言

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");  //DBと接続
			String sql = "select R.review_id,image,G.genre_name,price,puroduct_name,good "
					+ "from review as R join review_image as RI on R.review_id = RI.review_id "
					+ "right join genre as G on R.genre_id = G.genre_id "
					+ "where R.genre_id LIKE ? AND address LIKE ? AND user_name LIKE ? OR title LIKE ? OR series_name LIKE ? OR thought LIKE ? OR puroduct_name LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//もしも、genreに０が入力された場合、ワイルドカードの'％'を用いる。
			//そして、genreに０以外が入力された場合、そのままその値を格納する。
			if(genre == 0) {
				pStmt.setString(1,"%");
			}else {
				pStmt.setInt(1, genre);
			}
			pStmt.setString(2, "%"+address+"%");
			pStmt.setString(3, "%"+word+"%");
			pStmt.setString(4, "%"+word+"%");
			pStmt.setString(5, "%"+word+"%");
			pStmt.setString(6, "%"+word+"%");
			pStmt.setString(7, "%"+word+"%");

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//結果表をコレクションにコピーする
			while (rs.next()) {
				Review_List review  = new Review_List(
						rs.getInt("review_id"),
						rs.getString("image"),
						rs.getString("genre_name"),
						rs.getInt("price"),
						rs.getString("puroduct_name"),
						rs.getInt("good")
						);
				reviewList.add(review);
			}
			//END

		}catch (SQLException e) {
			e.printStackTrace();
			reviewList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			reviewList = null;
		}
		finally {  //DBを切断する↓↓
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					reviewList = null;
				}
			}
		}

		return reviewList;
	}

	//--------------------------------------------------------------------------------------------
	//select文
	public List<Review> select(Review review_id) {
		/*public List<Review> select(Stirng genre, ){*/ //バラバラに呼び出すやり方

		Connection conn = null;
		List<Review> reviewList = new ArrayList<Review>();


		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			String sql = "SELECT * FROM review WHERE review_id = ?";//変更部分
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int id = review_id.getReview_id();//変更部分


			pStmt.setInt(1, id);//変更部分


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする<<ここ改造>>//変更部分
			while (rs.next()) {
				Review review  = new Review(
						rs.getInt("review_id"),
						rs.getString("user_name"),
						rs.getInt("genre_id"),
						rs.getString("review_day"),
						rs.getString("title"),
						rs.getString("series_name"),
						rs.getString("thought"),
						rs.getInt("evalution"),
						rs.getInt("good"),
						rs.getString("address"),
						rs.getString("puroduct_name"),
						rs.getInt("price")
						);
				reviewList.add(review);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			reviewList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			reviewList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					reviewList = null;
				}
			}
		}

		// 結果を返す
		return reviewList;
	}

	//--------------------------------------------------------------------------------------------
	//他人の投稿一覧select文
	public List<Review_List> URselect(String user_name) {
		/*public List<Review> select(Stirng genre, ){*/ //バラバラに呼び出すやり方

		Connection conn = null;
		List<Review_List> reviewList = new ArrayList<Review_List>();


		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			String sql = "select review.review_id , genre_name , price , puroduct_name , good , image "
					+ "from review join review_image on review.review_id = review_image.review_id "
					+ "right join genre on review.genre_id = genre.genre_id WHERE user_name = ?";//変更部分
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);//変更部分


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする<<ここ改造>>//変更部分
			while (rs.next()) {
				Review_List detail = new Review_List(
				rs.getInt("review_id"),
				rs.getString("image"),
				rs.getString("genre_name"),
				rs.getInt("price"),
				rs.getString("puroduct_name"),
				rs.getInt("good")
				);
				reviewList.add(detail);
				}
		}
		catch (SQLException e) {
			e.printStackTrace();
			reviewList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			reviewList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					reviewList = null;
				}
			}
		}

		// 結果を返す
		return reviewList;
	}
	//--------------------------------------------------------------------------------------------
	//insert文
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Review review) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する<<ここを改造する>>
			String sql = "INSERT INTO Review (user_name, genre_id, review_day, title,"
					+" series_name, thought, evalution, good, address, puroduct_name, price) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<改造する>>
			if (review.getUser_name() != null && !review.getUser_name().equals("")) {
				pStmt.setString(1, review.getUser_name());
			}
			else {
				pStmt.setString(1, null);
			}
			if (review.getGenre_id() != 0) {
				pStmt.setInt(2, review.getGenre_id());
			}
			if (review.getReview_day() != null && !review.getReview_day().equals("")) {
				pStmt.setString(3, review.getReview_day());
			}
			else {
				pStmt.setString(3, null);
			}
			if (review.getTitle() != null && !review.getTitle().equals("")) {
				pStmt.setString(4, review.getTitle());
			}
			else {
				pStmt.setString(4, null);
			}
			if (review.getSeries_name() != null && !review.getSeries_name().equals("")) {
				pStmt.setString(5, review.getSeries_name());
			}
			else {
				pStmt.setString(5, null);
			}
			if (review.getThought() != null && !review.getThought().equals("")) {
				pStmt.setString(6, review.getThought());
			}
			else {
				pStmt.setString(6, null);
			}
			if (review.getEvalution() != 0) {
				pStmt.setInt(7, review.getEvalution());
			}
			else {
				pStmt.setString(7, null);
			}
			if (review.getAddress() != null && !review.getAddress().equals("")) {
				pStmt.setString(8, review.getAddress());
			}
			else {
				pStmt.setString(8, null);
			}
			if (review.getPuroduct_name() != null && !review.getPuroduct_name().equals("")) {
				pStmt.setString(9, review.getPuroduct_name());
			}
			else {
				pStmt.setString(9, null);
			}
			if (review.getPrice() != 0) {
				pStmt.setInt(10, review.getPrice());
			}
			else {
				pStmt.setInt(10, 0);
			}


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	//--------------------------------------------------------------------------------------------
	//いいねボタン
	public boolean goodcount(Review review_id) {
		Connection conn = null;
		boolean result = false;

		try {
			int good=0;
			List<Review> review_detailList = select(review_id);
			for (Review review_detail :  review_detailList) {
				good = review_detail.getGood();
			}
			good++;

			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する<<改造する>>
			String sql = "UPDATE Review set good=? WHERE review_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<改造する>>
			pStmt.setInt(1, good);

			pStmt.setInt(2, review_id.getReview_id());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	//--------------------------------------------------------------------------------------------
	//すべての投稿を呼び出す
	public List<Review> allselect() {
		/*public List<Review> select(Stirng genre, ){*/ //バラバラに呼び出すやり方

		Connection conn = null;
		List<Review> reviewList = new ArrayList<Review>();

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			String sql = "SELECT * FROM review ";//変更部分
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする<<ここ改造>>//変更部分
			while (rs.next()) {
				Review review  = new Review(
						rs.getInt("review_id"),
						rs.getString("user_name"),
						rs.getInt("genre_id"),
						rs.getString("review_day"),
						rs.getString("title"),
						rs.getString("series_name"),
						rs.getString("thought"),
						rs.getInt("evalution"),
						rs.getInt("good"),
						rs.getString("address"),
						rs.getString("product_name"),
						rs.getInt("price")
						);
				reviewList.add(review);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			reviewList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			reviewList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					reviewList = null;
				}
			}
		}
		// 結果を返す
		return reviewList;
	}

//------------------------------------------------------------------------------------------
//トレンドを呼び出す
public int TRselect() {
	/*public List<Review> select(Stirng genre, ){*/ //バラバラに呼び出すやり方

	Connection conn = null;
	int review_id = 0;


	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

		String sql = "select max(review_id) as review_id from review where good = (select max(good) from review where review_day >= (NOW() - INTERVAL 30 DAY))";
				//変更部分
		PreparedStatement pStmt = conn.prepareStatement(sql);

		ResultSet rs = pStmt.executeQuery();


		// 結果表をコレクションにコピーする<<ここ改造>>//変更部分
		while (rs.next()) {
				review_id = rs.getInt("review_id");
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		review_id = 0;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		review_id = 0;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				review_id = 0;
			}
		}
	}

	// 結果を返す
	return review_id;
  }
public List<Review_List> Tselect(int review_id) {
	/*public List<Review> select(Stirng genre, ){*/ //バラバラに呼び出すやり方

	Connection conn = null;
	List<Review_List> reviewList = new ArrayList<Review_List>();


	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

		String sql = "select review.review_id, genre_name , price , puroduct_name , good , image "
				+ "from review join review_image on review.review_id = review_image.review_id "
				+ "right join genre on review.genre_id = genre.genre_id WHERE review.review_id = ?";//変更部分
		PreparedStatement pStmt = conn.prepareStatement(sql);

		pStmt.setInt(1, review_id);//変更部分


		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする<<ここ改造>>//変更部分
		while (rs.next()) {
			Review_List detail = new Review_List(
			rs.getInt("review_id"),
			rs.getString("image"),
			rs.getString("genre_name"),
			rs.getInt("price"),
			rs.getString("puroduct_name"),
			rs.getInt("good")
			);
			reviewList.add(detail);
			}
	}
	catch (SQLException e) {
		e.printStackTrace();
		reviewList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		reviewList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				reviewList = null;
			}
		}
	}

	// 結果を返す
	return reviewList;
}
}



