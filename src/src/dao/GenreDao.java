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

	public List<Genre> select(int genre_id) {
		Connection conn = null;
		List<Genre> GenreList = new ArrayList<Genre>();;

		try {
			// JDBC�h���C�o��ǂݍ���
			Class.forName("org.h2.Driver");

			// �f�[�^�x�[�X�ɐڑ�����
			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

			// SQL������������
			String sql = "select * from genre where genre_id = ? ORDER BY genre_id ASC" ;

			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL��������������
			//ID----------------------------------------------
				pStmt.setInt(1, genre_id );

			// SQL�������s���A���ʕ\���擾����
			ResultSet rs = pStmt.executeQuery();

			// ���ʕ\���R���N�V�����ɃR�s�[����
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
			// �f�[�^�x�[�X��ؒf
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
		// ���ʂ�Ԃ�
		return GenreList;
	}
}
