package model;

public class Favorite_Reviewer {

	private String user_name;
	private int reviewer_id;

	public Favorite_Reviewer(String user_name, int reviewer_id) {
		this.user_name = user_name;
		this.reviewer_id = reviewer_id;
	}

	public Favorite_Reviewer(int reviewer_id) {
		this.reviewer_id = reviewer_id;
	}

	public Favorite_Reviewer() {
		this.user_name = "";
		this.reviewer_id = 0;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getReviewer_id() {
		return reviewer_id;
	}
	public void setReviewer_id(int reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
}
