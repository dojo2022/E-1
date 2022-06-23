package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Review_List;

public class Favorite_ReviewDao {

	public List<Review_List> favrevselect(String user_name) {
		Connection conn = null;
		List<Review_List> favorite_review_list = new ArrayList<Review_List>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "select review.review_id , genre_name , price , puroduct_name , good , image "
					+ "from review join review_image on review.review_id = review_image.review_id "
					+ "right join genre on review.genre_id = genre.genre_id "
					+ "where review.review_id in (select favorite_review.review_id from favorite_review where user_name = ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
			Review_List detail = new Review_List(
			rs.getInt("review_id"),
			rs.getString("image"),
			rs.getString("genre_name"),
			rs.getInt("price"),
			rs.getString("puroduct_name"),
			rs.getInt("good")
			);
			favorite_review_list.add(detail);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			favorite_review_list = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			favorite_review_list = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					favorite_review_list = null;
				}
			}
		}

		// 結果を返す
		return favorite_review_list;
	}

	public boolean insert(String user_name, int review_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "insert into favorite_review (user_name, review_id) values (?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_name);
			pStmt.setInt(2, review_id);

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

	public boolean delete(String user_name, int review_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "delete from favorite_review where user_name = ? and review_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_name);
			pStmt.setInt(2, review_id);

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
