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

	public String getId() {
		return id;
	}
	public void setId(String user_name) {
		this.id = user_name;
	}
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
}
