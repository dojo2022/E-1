package model;

public class test {

	private String id;
	private String user_image;

	public test(String user_name, String user_image) {
		this.id = user_name;
		this.user_image = user_image;
	}

	public test(String user_image) {
		this.user_image = user_image;
	}

	public test() {
		this.id = "";
		this.user_image = "";
	}

	public String getUser_name() {
		return id;
	}
	public void setUser_name(String user_name) {
		this.id = user_name;
	}
	public String getReviewer_id() {
		return user_image;
	}
	public void setReviewer_id(String user_image) {
		this.user_image = user_image;
	}
}
