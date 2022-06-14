package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Idpw;

public class IdpwDao {
	public boolean isLoginOK(Idpw idpw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");
			String sql = "SELECT COUNT(*) FROM USER WHERE ID = ? AND PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, idpw.getId());
			pStmt.setString(2,idpw.getPw());

			ResultSet rs = pStmt.executeQuery();
			rs.next();
			if(rs.getInt("count(*)")==1) {
				loginResult = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		return loginResult;
	}
}
