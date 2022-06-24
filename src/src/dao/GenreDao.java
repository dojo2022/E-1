package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Genre;

public class GenreDao {

	public List<Genre> select() {
		Connection conn = null;
		List<Genre> GenreList = new ArrayList<Genre>();;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "select * from genre ORDER BY genre_id ASC" ;

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Genre genre = new Genre(
						rs.getInt("genre_id"),
						rs.getString("genre_name")
						);
				GenreList.add(genre);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			GenreList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			GenreList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					GenreList = null;
				}
			}
		}
		// 結果を返す
		return GenreList;
	}

	public String GNselect(int genre_id) {
		Connection conn = null;
		String genre_name = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "select genre_name from genre where genre_id = ? ORDER BY genre_id ASC" ;

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1,genre_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーするy
			while (rs.next()) {
			genre_name = rs.getString("genre_name");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			genre_name = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			genre_name = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					genre_name = null;
				}
			}
		}
		// 結果を返す
		return genre_name;
	}
}
