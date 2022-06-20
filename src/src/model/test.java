package model;

public class test {

	private String user_name;
	private String reviewer_id;

	public test(String user_name, String reviewer_id) {
		this.user_name = user_name;
		this.reviewer_id = reviewer_id;
	}

	public test(String reviewer_id) {
		this.reviewer_id = reviewer_id;
	}

	public test() {
		this.user_name = "";
		this.reviewer_id = "";
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getReviewer_id() {
		return reviewer_id;
	}
	public void setReviewer_id(String reviewer_id) {
		this.reviewer_id = reviewer_id;
	}
}
