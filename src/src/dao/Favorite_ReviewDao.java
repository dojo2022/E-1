package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Favorite_Review;

public class Favorite_ReviewDao {

	public List<Favorite_Review> favselect() {
		Connection conn = null;
		List<Favorite_Review> cardList = new ArrayList<Favorite_Review>();

		try {
			// JDBC�h���C�o��ǂݍ���
			Class.forName("org.h2.Driver");

			// �f�[�^�x�[�X�ɐڑ�����
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL������������
			String sql = "select * from MYBC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL�������s���A���ʕ\���擾����
			ResultSet rs = pStmt.executeQuery();

			// ���ʕ\���R���N�V�����ɃR�s�[����
			while (rs.next()) {
				Mybc card = new Mybc(
				rs.getString("NUMBER"),
				rs.getString("NAME"),
				rs.getString("ADDRESS"),
				rs.getString("CNAME"),
				rs.getString("DEPARTMENT"),
				rs.getString("URL"),
				rs.getString("EMAIL"),
				rs.getString("TEL")
				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// �f�[�^�x�[�X��ؒf
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// ���ʂ�Ԃ�
		return cardList;
	}

}
