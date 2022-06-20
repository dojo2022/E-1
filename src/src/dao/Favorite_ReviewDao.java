package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Favorite_Review;

public class Favorite_ReviewDao {

	public List<Favorite_Review> favrevimgselect(String user_name) {
		Connection conn = null;
		List<Favorite_Review> favorite_user_list = new ArrayList<Favorite_Review>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "select image from review_image where review_id in (select review_id from favorite_review where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
			Review_image image = new Review_image(
			rs.getString("image")
			);
			favorite_user_list.add(image);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			favorite_user_list = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			favorite_user_list = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					favorite_user_list = null;
				}
			}
		}

		// 結果を返す
		return favorite_user_list;
	}
	
	public List<Favorite_Review> favrevgnrselect(String user_name) {
		Connection conn = null;
		List<Favorite_Review> favorite_user_list = new ArrayList<Favorite_Review>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "select genre_name from genre where genre_id in (select gnre_id from favorite_review where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
			Review_image image = new Review_image(
			rs.getString("image")
			);
			favorite_user_list.add(image);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			favorite_user_list = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			favorite_user_list = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					favorite_user_list = null;
				}
			}
		}

		// 結果を返す
		return favorite_user_list;
	}

}
