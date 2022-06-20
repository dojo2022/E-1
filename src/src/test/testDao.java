package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.test;

public class testDao {
		public List<test> favselect(String user_id) {
			Connection conn = null;
			List<test> favorite_user_list = new ArrayList<test>();

			try {
				// JDBC�h���C�o��ǂݍ���
				Class.forName("org.h2.Driver");

				// �f�[�^�x�[�X�ɐڑ�����
				conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

				// SQL������������
				String sql = "select id, user_image from user where id in (select reviewer_id from favorite_reviewer where user_name = ?);";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, user_id);

				// SQL�������s���A���ʕ\���擾����
				ResultSet rs = pStmt.executeQuery();

				// ���ʕ\���R���N�V�����ɃR�s�[����
				while (rs.next()) {
				test card = new test(
				rs.getString("id"),
				rs.getString("user_image")
				);
				favorite_user_list.add(card);
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
