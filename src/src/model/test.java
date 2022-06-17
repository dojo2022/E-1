package model;

import java.io.Serializable;

public class test implements Serializable {
	private String id;
	private String pw;
	private String image;

	public test(String id, String pw, String image) {
		this.id = id;
		this.pw = pw;
		this.image = image;
	}

	public test(String id, String image) {
		this.id = id;
		this.image = image;
	}

	public test() {
		this.id = "";
		this.pw = "";
		this.image = "";
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

}