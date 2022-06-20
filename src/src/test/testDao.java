package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.test;

public class testDao {
		public List<test> favselect(String user_id) {
			Connection conn = null;
			List<test> favorite_user_list = new ArrayList<test>();

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
				test card = new test(
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
}
