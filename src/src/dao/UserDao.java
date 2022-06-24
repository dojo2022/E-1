package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
/*------------------------SELECT----------------------------------*/
// 引数idで検索項目を指定し、検索結果のリストを返す
public class UserDao {
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

	/*------------------------INSERT----------------------------------*/
	 // 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(String User_id, String pw){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO User (id, pw, user_image, public) VALUES ( ?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			//ID----------------------------------------------
			if (!User_id.equals("")) {
				pStmt.setString(1, User_id);
			}
			else {
				pStmt.setString(1, null);
			}
			//PW----------------------------------------------
			if (!pw.equals("")) {
				pStmt.setString(2, pw);
			}
			else {
				pStmt.setString(2, null);
			}
			//IMAGE----------------------------------------------
			pStmt.setString(3, "");

			//PUBLIC----------------------------------------------
			pStmt.setString(4, "no");

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

	/*------------------------UPDATE----------------------------------*/
///*
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(String old_id, String new_id, String image, String c_public){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE User SET id = ?, user_image = ? , public= ? WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//new_ID----------------------------------------------
			pStmt.setString(1, new_id);
			//IMAGE----------------------------------------------
			pStmt.setString(2, image);
			//PUBLIC----------------------------------------------
			pStmt.setString(3, c_public);
			//new_ID----------------------------------------------
			pStmt.setString(4, old_id);

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
	//*/




}
