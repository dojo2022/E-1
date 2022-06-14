package model;

public class Idpw {
	private String id;
	private String pw;

	public Idpw(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public Idpw() {
		this.id = "";
		this.pw = "";
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
}
