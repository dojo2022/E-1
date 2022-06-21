package model;

import java.io.Serializable;

public class User implements Serializable {
	private String id;
	private String pw;
<<<<<<< HEAD
	private String user_image;

	public User(String id, String pw, String user_image) {
		this.id = id;
		this.pw = pw;
		this.user_image = user_image;
	}

	public User(String user_name, String user_image) {
		this.id = user_name;
		this.user_image = user_image;
=======
	private String image;
	private String c_public;

	public User(String id, String pw, String image, String c_public ) {
		this.id = id;
		this.pw = pw;
		this.image = image;
		this.c_public = c_public;
>>>>>>> ad106e80f54b2705d007d1a01f88c7420f792d65
	}

	public User() {
		this.id = "";
		this.pw = "";
<<<<<<< HEAD
		this.user_image = "";
=======
		this.image = "";
		this.c_public = "no";
>>>>>>> ad106e80f54b2705d007d1a01f88c7420f792d65
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

	public String getC_public() {
		return c_public;
	}

	public void setC_public(String c_public) {
		this.c_public = c_public;
	}

}