package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

		public List<Review_Image> select(int review_id) {
			/*public List<Review> select(Stirng genre, ){*/ //バラバラに呼び出すやり方

			Connection conn = null;
			List<Review_Image> review_imageList = new ArrayList<Review_Image>();


			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:/data/dokogacha", "sa", "");

				String sql = "select review_id , image from review_image WHERE review_id = ?";//変更部分
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setInt(1, review_id);//変更部分


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする<<ここ改造>>//変更部分
				while (rs.next()) {
					Review_Image image = new Review_Image(
					rs.getInt("review_id"),
					rs.getString("image")
					);
					review_imageList.add(image);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				review_imageList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				review_imageList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						review_imageList = null;
					}
				}
			}

			// 結果を返す
			return review_imageList;
		}

}
