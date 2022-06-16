package model;

//称号テーブル(title)の

public class Title {
	private	int total_good; //total_good
	private String image;   //画像画像URL
	private String name;		//称号名

	public Title(int total_good, String image, String name ) {
		this.total_good = total_good;
		this.image = image;
		this.name = name;
	}

	public Title(){
		this.total_good = 0;
		this.image = "";
		this.name = "";
	}

	public int getTotal_good() {
		return total_good;
	}

	public void setTotal_good(int total_good) {
		this.total_good = total_good;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
