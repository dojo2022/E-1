package model;

public class Review_Image {
	private int review_id;
	private String image;

	public Review_Image(int review_id, String image) {
		this.review_id = review_id;
		this.image = image;
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

}
