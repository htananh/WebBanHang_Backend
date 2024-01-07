package com.tananh.request;

public class AddCartRequest {

	private Long productId;
	private String Capacity;
	private String Color;
	private Long discountedPrice;
	public AddCartRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddCartRequest(Long productId, String capacity, String color, Long discountedPrice) {
		super();
		this.productId = productId;
		Capacity = capacity;
		Color = color;
		this.discountedPrice = discountedPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getCapacity() {
		return Capacity;
	}
	public void setCapacity(String capacity) {
		Capacity = capacity;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public Long getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(Long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	
	
}
