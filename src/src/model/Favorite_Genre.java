package model;

public class Favorite_Genre {
	private String user_name;
	private int id;
	private String genre_name;

	public Favorite_Genre(String user_name, int id, String genre_name){
		this.user_name =user_name;
		this.id = id;
		this.genre_name =  genre_name;
	}

	public Favorite_Genre(){
		this.user_name ="";
		this.id = 0;
		this.genre_name = "";
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
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
}
