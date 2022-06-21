package test;

import java.util.List;

import dao.ReviewDao;
import model.Review;

public class TestReviewDao {
	public static void main(String[] args) {
		ReviewDao rDao = new ReviewDao();
		if (rDao.insert(new Review(0, "user_name", 1, "review_day", "title", "series", "thought", 1, 0, "address", "product_name", 100))){
			System.out.println("登録成功！");
			List<Review> ReviewList1 = rDao.allselect();
			for (Review review : ReviewList1) {
				System.out.println("　id：" + review.getReview_id());
				System.out.println("　User_name：" + review.getUser_name());
				System.out.println("　Genre_id：" + review.getGenre_id());
				System.out.println("　Review_day：" + review.getReview_id());
				System.out.println("　Title：" + review.getTitle());
				System.out.println("　Series_name：" + review.getSeries_name());
				System.out.println("　Thought：" + review.getThought());
				System.out.println("　Evalution：" + review.getEvalution());
				System.out.println("　Good：" + review.getGood());
				System.out.println("　Address：" + review.getAddress());
				System.out.println("　Product_name：" + review.getProduct_name());
				System.out.println("　Price：" + review.getPrice());

				System.out.println();
				}

		}
		else {
			System.out.println("登録失敗！");
		}

	}
}
