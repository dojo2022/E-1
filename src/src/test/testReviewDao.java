package test;

import dao.ReviewDao;
import model.Review;

public class TestReviewDao {
	public static void main(String[] args) {
		ReviewDao rDao = new ReviewDao();
		if (rDao.insert(new Review(0, "user_name", 1, "review_day", "title", "series", "thought", 1, 0, "address", "product_name", 100))){
			System.out.println("登録成功！");
			/*
			List<User> recordList3 = rDao.select("");
			for (User record : recordList3) {
				System.out.println("　id：" + record.getId());
				System.out.println("　User_image：" + record.getImage());
				System.out.println("　public：" + record.getC_public());
				System.out.println();
				}
			*/
		}
		else {
			System.out.println("登録失敗！");
		}

	}
}
