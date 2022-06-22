package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

//--------------------------------------------------------------------------------------------
//search文
public class ReviewDao {
	//↓↓searchメソッドの作成開始
	public List<Review> search(int genre, String word, String address){
		List<Review> reviewList = new ArrayList<Review>();
		Connection conn = null;  //DBと接続するメソッドを宣言

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");  //DBと接続
			String sql = "select user_name, R.genre_id, G.genre_name, price, puroduct_name, good, address, review_id, review_day, title, series_name, thought, evalution "
					+"from genre AS G, review AS R "
					+"where G.genre_id = R.genre_id AND R.genre_id LIKE ? AND address LIKE ? AND user_name LIKE ? OR "
					+"title LIKE ? OR series_name LIKE ? OR thought LIKE ? OR puroduct_name LIKE ?";
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
	//--------------------------------------------------------------------------------------------
	//insert文
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Review review_id) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する<<ここを改造する>>
			String sql = "INSERT INTO Review (user_name, genre_id, review_day, title, series_name, thought, evalution, good, address, puroduct_name, price)\r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<改造する>>
			if (review_id.getUser_name() != null && !review_id.getUser_name().equals("")) {
				pStmt.setString(1, review_id.getUser_name());
			}
			else {
				pStmt.setString(1, null);
			}
			if (review_id.getGenre_id() != 0) {
				pStmt.setInt(2, review_id.getGenre_id());
			}
			if (review_id.getReview_day() != null && !review_id.getReview_day().equals("")) {
				pStmt.setString(3, review_id.getReview_day());
			}
			else {
				pStmt.setString(3, null);
			}
			if (review_id.getTitle() != null && !review_id.getTitle().equals("")) {
				pStmt.setString(4, review_id.getTitle());
			}
			else {
				pStmt.setString(4, null);
			}
			if (review_id.getSeries_name() != null && !review_id.getSeries_name().equals("")) {
				pStmt.setString(5, review_id.getSeries_name());
			}
			else {
				pStmt.setString(5, null);
			}
			if (review_id.getThought() != null && !review_id.getThought().equals("")) {
				pStmt.setString(6, review_id.getThought());
			}
			else {
				pStmt.setString(6, null);
			}
			if (review_id.getEvalution() != 0) {
				pStmt.setInt(7, review_id.getEvalution());
			}
			else {
				pStmt.setString(7, null);
			}
			if (review_id.getAddress() != null && !review_id.getAddress().equals("")) {
				pStmt.setString(8, review_id.getAddress());
			}
			else {
				pStmt.setString(8, null);
			}
			if (review_id.getProduct_name() != null && !review_id.getProduct_name().equals("")) {
				pStmt.setString(9, review_id.getProduct_name());
			}
			else {
				pStmt.setString(9, null);
			}
			if (review_id.getPrice() != 0) {
				pStmt.setInt(10, review_id.getPrice());
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

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
}



