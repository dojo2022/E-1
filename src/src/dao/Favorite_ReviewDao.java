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
			String sql = "select genre_name , price , puroduct_name , good , image "
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
}
