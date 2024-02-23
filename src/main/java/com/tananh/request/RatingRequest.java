package com.tananh.request;

public class RatingRequest {
	public double Rating;
	public Long productId;
	public RatingRequest(double rating, Long productId) {
		super();
		Rating = rating;
		this.productId = productId;
	}
	public RatingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getRating() {
		return Rating;
	}
	public void setRating(double rating) {
		Rating = rating;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
