package model;

import java.io.Serializable;

public class User implements Serializable {
	private String id;
	private String pw;
	private String user_image;

	public User(String id, String pw, String user_image) {
		this.id = id;
		this.pw = pw;
		this.user_image = user_image;
	}

	public User(String user_name, String user_image) {
		this.id = user_name;
		this.user_image = user_image;
	}

	public User() {
		this.id = "";
		this.pw = "";
		this.user_image = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

}