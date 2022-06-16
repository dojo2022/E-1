package model;

public class Favorite_Review {
	private String user_name;
	private int review_id;

	public Favorite_Review(String user_name, int review_id) {
		this.user_name = user_name;
		this.review_id = review_id;
	}

	public Favorite_Review() {
		this.user_name = "";
		this.review_id = 0;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
}
