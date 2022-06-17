package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Favorite_Review;
import model.Favorite_Reviewer;

public class Favorite_ReviewDao {

	public List<Favorite_Review> favselect(int user_name) {
		Connection conn = null;
		List<Favorite_Review> favorite_user_list = new ArrayList<Favorite_Review>();

		try {
			// JDBC�h���C�o��ǂݍ���
			Class.forName("org.h2.Driver");

			// �f�[�^�x�[�X�ɐڑ�����
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL������������
			String sql = "select * from favorite_reviewer where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, user_name);

			// SQL�������s���A���ʕ\���擾����
			ResultSet rs = pStmt.executeQuery();

			// ���ʕ\���R���N�V�����ɃR�s�[����
			while (rs.next()) {
			Favorite_Reviewer id = new Favorite_Reviewer(
			rs.getInt("reviewer_id")
			);
			favorite_user_list.add(id);
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
			// �f�[�^�x�[�X��ؒf
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

		// ���ʂ�Ԃ�
		return favorite_user_list;
	}

}
