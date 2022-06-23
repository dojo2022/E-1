package model;

public class Favorite_Genre {
	private String user_name;
	private int id;

	public Favorite_Genre(String user_name, int id){
		this.user_name =user_name;
		this.id = id;
	}

	public Favorite_Genre(){
		this.user_name ="";
		this.id = 0;
	}


	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
