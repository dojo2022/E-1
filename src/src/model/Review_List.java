package model;

public class Review_List {
	private int review_id;
	private String image;
	private String genre_name;
	private int price;
	private String puroduct_name;
	private int good;

	public Review_List(int review_id ,String image, String genre_name, int price, String puroduct_name, int good) {
		super();
		this.review_id = review_id;
		this.image = image;
		this.genre_name = genre_name;
		this.price = price;
		this.puroduct_name = puroduct_name;
		this.good = good;
	}

	public Review_List() {
		super();
		this.review_id = 0;
		this.image = "";
		this.genre_name = "";
		this.price = 0;
		this.puroduct_name = "";
		this.good = 0;
	}


	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPuroduct_name() {
		return puroduct_name;
	}

	public void setPuroduct_name(String puroduct_name) {
		this.puroduct_name = puroduct_name;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}



}