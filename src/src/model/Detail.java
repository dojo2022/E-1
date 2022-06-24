package model;

public class Detail {
	private int review_id;
	private String user_name;
	private String genre_name;
	private String title;
	private String series_name;
	private String thought;
	private int evalution;
	private int good;
	private String address;
	private String puroduct_name;
	private int price;
	private String image;

	public Detail(int review_id, String user_name, String genre_name, String title, String series_name, String thought,
			int evalution, int good, String address, String puroduct_name, int price, String image) {
		super();
		this.review_id = review_id;
		this.user_name = user_name;
		this.genre_name = genre_name;
		this.title = title;
		this.series_name = series_name;
		this.thought = thought;
		this.evalution = evalution;
		this.good = good;
		this.address = address;
		this.puroduct_name = puroduct_name;
		this.price = price;
		this.image = image;
	}

	public Detail() {
		super();
		this.review_id = 0;
		this.user_name = "";
		this.genre_name = "";
		this.title = "";
		this.series_name = "";
		this.thought = "";
		this.evalution = 0;
		this.good = 0;
		this.address = "";
		this.puroduct_name = "";
		this.price = 0;
		this.image = "";
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSeries_name() {
		return series_name;
	}

	public void setSeries_name(String series_name) {
		this.series_name = series_name;
	}

	public String getThought() {
		return thought;
	}

	public void setThought(String thought) {
		this.thought = thought;
	}

	public int getEvalution() {
		return evalution;
	}

	public void setEvalution(int evalution) {
		this.evalution = evalution;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPuroduct_name() {
		return puroduct_name;
	}

	public void setPuroduct_name(String puroduct_name) {
		this.puroduct_name = puroduct_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
