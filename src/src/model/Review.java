package model;

public class Review {
	private int review_id;
	private String user_name;
	private int genre_id;
	private String review_day;
	private String title;
	private String series_name;
	private String thought;
	private int evalution;
	private int good;
	private String address;
	private String product_name;
	private int price;

	public Review(int review_id, String user_name, int genre_id, String review_day, String title, String series_name,
			String thought, int evalution, int good, String address, String product_name, int price
			) {
		super();
		this.review_id = review_id;
		this.user_name = user_name;
		this.genre_id = genre_id;
		this.review_day = review_day;
		this.title = title;
		this.series_name = series_name;
		this.thought = thought;
		this.evalution = evalution;
		this.good = good;
		this.address = address;
		this.product_name = product_name;
		this.price = price;
	}

	public Review() {
		super();
		this.review_id = 0;
		this.user_name = "";
		this.genre_id = 0;
		this.review_day = "";
		this.title = "";
		this.series_name = "";
		this.thought = "";
		this.evalution = 0;
		this.good = 0;
		this.address = "";
		this.product_name = "";
		this.price = 0;
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

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getReview_day() {
		return review_day;
	}

	public void setReview_day(String review_day) {
		this.review_day = review_day;
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

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
