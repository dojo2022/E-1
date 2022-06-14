package model;

public class LoginUser {
	private String name;	// ログイン時のID

	public LoginUser() {
		this(null);
	}

	public LoginUser(String name) {
		this.name = name;
	}

	public String getId() {
		return name;
	}

	public void setUserId(String name) {
		this.name = name;
	}
}
