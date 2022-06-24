package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Review_Image;

public class Review_ImageDao {
	//--------------------------------------------------------------------------------------------
			//insert_image文
		public boolean insert_image(Review_Image review) {
			Connection conn = null;
			boolean result = false;

			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");
				String sql = "INSERT INTO review_image (review_id, image) VALUES (?,?)";

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1,review.getReview_id());

				if(review.getImage() != "" || review.getImage() != null) {
					pStmt.setString(2, review.getImage());
				}else {
					pStmt.setString(2, null);
				}


				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch(SQLException e) {
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

			return result;
		}

}
