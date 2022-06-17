package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Review;

public class ReviewDao {
	public boolean select(Review review_id) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/dokogacha", "sa", "");

			String sql = "SELECT * FROM review WHERE review_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int id = review_id.getReview_id();


				pStmt.setInt(1, id);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする<<ここ改造>>
				while (rs.next()) {
					Review id = new Review(
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
					List.add(id);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}
}
