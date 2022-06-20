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

	public List<Favorite_Review> favrevimgselect(String user_name) {
		Connection conn = null;
		List<Favorite_Review> favorite_user_list = new ArrayList<Favorite_Review>();

		try {
			// JDBC�h���C�o��ǂݍ���
			Class.forName("org.h2.Driver");

			// �f�[�^�x�[�X�ɐڑ�����
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL������������
			String sql = "select image from review_image where review_id in (select review_id from favorite_review where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL�������s���A���ʕ\���擾����
			ResultSet rs = pStmt.executeQuery();

			// ���ʕ\���R���N�V�����ɃR�s�[����
			while (rs.next()) {
			Review_image image = new Review_image(
			rs.getString("image")
			);
			favorite_user_list.add(image);
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
	
	public List<Favorite_Review> favrevgnrselect(String user_name) {
		Connection conn = null;
		List<Favorite_Review> favorite_user_list = new ArrayList<Favorite_Review>();

		try {
			// JDBC�h���C�o��ǂݍ���
			Class.forName("org.h2.Driver");

			// �f�[�^�x�[�X�ɐڑ�����
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL������������
			String sql = "select genre_name from genre where genre_id in (select gnre_id from favorite_review where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL�������s���A���ʕ\���擾����
			ResultSet rs = pStmt.executeQuery();

			// ���ʕ\���R���N�V�����ɃR�s�[����
			while (rs.next()) {
			Review_image image = new Review_image(
			rs.getString("image")
			);
			favorite_user_list.add(image);
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
