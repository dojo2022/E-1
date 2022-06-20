package dao;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Idpw;

public class IdpwDao {
	public boolean insert(Idpw card) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C://data/dokogacha", "sa", "");

			String sql = "INSERT INTO user (id,pw) VALUES (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			String id = card.getId();
			String pw = card.getPw();
			byte[] cipher_byte;

			if(id != null && !id.equals("")) {
				pStmt.setString(1, id);
			}else {
				pStmt.setString(1, null);
			}
			if(pw != null && !pw.equals("")) {
				try {
					MessageDigest md = MessageDigest.getInstance("SHA-256");
					md.update(pw.getBytes());
					cipher_byte=md.digest();
					StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
					for(byte b: cipher_byte) {
						sb.append(String.format("%02x", b&0xff));
					}
					pw = sb.toString();
				}catch(Exception e) {
					e.printStackTrace();
				}
				pStmt.setString(2, pw);
			}else {
				pStmt.setString(2, null);
			}
			if(pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public boolean isLoginOK(Idpw idpw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C://data/dokogacha", "sa", "");
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
