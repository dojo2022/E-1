package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Favorite_GenreDao {
//引数idで検索項目を指定し、検索結果のリストを返す
	public ArrayList<String> select(String user_id) {
		Connection conn = null;
		ArrayList<String> FGenreList = new ArrayList<String>();;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "SELECT genre.genre_name\r\n"
								 + "from User join Favorite_genre on User.id = Favorite_genre.user_name \r\n"
								 + "right join genre on  Favorite_genre.genre_id = genre.genre_id\r\n"
								 + "WHERE user.id = ? ORDER BY id ASC";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			//ID----------------------------------------------
				pStmt.setString(1, user_id );

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				String genre_name = rs.getString("genre_name");

				FGenreList.add(genre_name);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			FGenreList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			FGenreList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					FGenreList = null;
				}
			}
		}
		// 結果を返す
		return FGenreList;
		}
}
