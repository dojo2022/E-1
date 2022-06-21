package test;

import java.util.List;

import dao.ReviewDao;
import model.Review;

public class testReviewDao {
	public static void main(String[] args) {
		ReviewDao rDao = new ReviewDao();
		List<Review> review_detailList = rDao.select(new Review());
		System.out.println();
	}
}
