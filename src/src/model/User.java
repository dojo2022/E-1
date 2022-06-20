package model;

import java.io.Serializable;

public class User implements Serializable {
	private String id;
	private String pw;
	private String image;
	private String c_public;

	public User(String id, String pw, String image, String c_public ) {
		this.id = id;
		this.pw = pw;
		this.image = image;
		this.c_public = c_public;
	}

	public User() {
		this.id = "";
		this.pw = "";
		this.image = "";
		this.c_public = "no";
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getC_public() {
		return c_public;
	}

	public void setC_public(String c_public) {
		this.c_public = c_public;
	}

}