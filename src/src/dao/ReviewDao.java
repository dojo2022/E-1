package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review;

public class ReviewDao {
	public List<Review> select(Review review_id) {
		Connection conn = null;
		List<Review> reviewList = new ArrayList<Review>();


		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			String sql = "SELECT * FROM review WHERE review_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int id = review_id.getReview_id();


				pStmt.setInt(1, id);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする<<ここ改造>>
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
					rs.getInt("price"),
					rs.getString("product_detail")
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
				String sql = "INSERT INTO Review (user_name, genre_id, review_day, title, series_name, thought, evalution, good, address, product_name, price, product_detail)\r\n"
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる<<改造する>>
				if (review_id.getProduct_name() != null && !review_id.getProduct_name().equals("")) {
					pStmt.setString(1, review_id.getProduct_name());
				}
				else {
					pStmt.setString(1, null);
				}
				if (review_id.getUser_name() != null && !review_id.getUser_name().equals("")) {
					pStmt.setString(2, review_id.getUser_name());
				}
				else {
					pStmt.setString(2, null);
				}
				if (review_id.getGenre_id() != 0) {
					pStmt.setInt(3, review_id.getGenre_id());
				}
				else {
					pStmt.setString(3, null);
				}
				if (review_id.getReview_day() != null && !review_id.getReview_day().equals("")) {
					pStmt.setString(4, review_id.getReview_day());
				}
				else {
					pStmt.setString(4, null);
				}
				if (review_id.getTitle() != null && !review_id.getTitle().equals("")) {
					pStmt.setString(5, review_id.getTitle());
				}
				else {
					pStmt.setString(5, null);
				}
				if (review_id.getSeries_name() != null && !review_id.getSeries_name().equals("")) {
					pStmt.setString(6, review_id.getSeries_name());
				}
				else {
					pStmt.setString(6, null);
				}
				if (review_id.getThought() != null && !review_id.getThought().equals("")) {
					pStmt.setString(7, review_id.getThought());
				}
				else {
					pStmt.setString(7, null);
				}
				if (review_id.getEvalution() != null && !review_id.getEvalution().equals("")) {
					pStmt.setString(8, review_id.getEvalution());
				}
				else {
					pStmt.setString(8, null);
				}
				if (review_id.getGood() != null && !review_id.getGood().equals("")) {
					pStmt.setString(9, review_id.getGood());
				}
				else {
					pStmt.setString(9, null);
				}
				if (review_id.getAddress() != null && !review_id.getAddress().equals("")) {
					pStmt.setString(10, review_id.getAddress());
				}
				else {
					pStmt.setString(10, null);
				}
				if (review_id.getProduct_name() != null && !review_id.getProduct_name().equals("")) {
					pStmt.setString(11, review_id.getProduct_name());
				}
				else {
					pStmt.setString(11, null);
				}
				if (review_id.getPrice() != null && !review_id.getPrice().equals("")) {
					pStmt.setString(12, review_id.getPrice());
				}
				else {
					pStmt.setString(12, null);
				}
				if (review_id.getProduct_detail() != null && !review_id.getProduct_detail().equals("")) {
					pStmt.setString(13, review_id.getProduct_detail());
				}
				else {
					pStmt.setString(13, null);
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
}