package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Title;

public class TitleDao {

	/*-----------select--------------------------------------------------------------*/
	public Title select(int totalgood) {
		Title title = new Title();
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL文を準備する
			String sql = "SELECT *  FROM title WHERE total_good <= ? ORDER BY total_good DESC limit 1";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			//ID----------------------------------------------
				pStmt.setInt(1, totalgood );

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()){
				title.setTotal_good(rs.getInt("total_good"));
				title.setImage(rs.getString("title_image"));
				title.setName(rs.getString("title_name"));

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			title = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			title = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					title = null;
				}
			}
		}
		// 結果を返す
		return title;
	}
/*-----------totalgood--------------------------------------------------------------*/
	public int totalgood(String user_id) {

		int totalgood = 0;
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			String sql = "SELECT sum(good)  FROM REVIEW  where user_name = ?;";//変更部分
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_id);//変更部分


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする<<ここ改造>>//変更部分
			while (rs.next()) {
				totalgood = rs.getInt("SUM(good)");
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
		return totalgood;
	}

	/*-----------end class--------------------------------------------------------------*/
}