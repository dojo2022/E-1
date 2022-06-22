package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class TitleDao {
	public List<User> select(String user_id) {
		Connection conn = null;
		List<User> UserList = new ArrayList<User>();;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "SELECT *  FROM User WHERE id = ? ORDER BY id ASC" ;

			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			//ID----------------------------------------------
				pStmt.setString(1, user_id );

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUser_image(rs.getString("user_image"));
				user.setC_public(rs.getString("public"));
				UserList.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			UserList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			UserList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					UserList = null;
				}
			}
		}
		// 結果を返す
		return UserList;
	}
}
