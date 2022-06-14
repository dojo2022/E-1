package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	public boolean login(User user) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			String sql = "SELECT COUNT(*) FROM USER WHERE USER_ID = ? AND USER_PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,user.getId());
			pStmt.setString(2,user.getPw());

			ResultSet rs = pStmt.executeQuery();

			rs.next();
			if(rs.getInt("count(*)") == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}

		return result;
	}
}
