package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Favorite_Review;
import model.test;

public class testDao {
]
		public List<Favorite_Review> favselect(int user_id) {
			Connection conn = null;
			List<Favorite_Review> favorite_user_list = new ArrayList<Favorite_Review>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

				// SQL文を準備する
				String sql = "select * from user where id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setInt(1, user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				test card = new test(
				rs.getString("user_id"),
				rs.getString("user_icon")
				);
				favorite_user_list.add(card);
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
