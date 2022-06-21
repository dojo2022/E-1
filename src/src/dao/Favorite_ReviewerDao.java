package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class Favorite_ReviewerDao {
		public List<User> favselect(String user_id) {
			Connection conn = null;
			List<User> favorite_user_list = new ArrayList<User>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

				// SQL文を準備する
				String sql = "select id, user_image from user where id in (select reviewer_id from favorite_reviewer where user_name = ?);";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
				User card = new User(
				rs.getString("id"),
				rs.getString("user_image")
				);
				favorite_user_list.add(card);
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

		public boolean delete(String user_name, String reviewer_id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

				// SQL文を準備する
				String sql = "delete from favorite_reviewer where user_name = ? and reviewer_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, user_name);
				pStmt.setString(2, reviewer_id);

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
