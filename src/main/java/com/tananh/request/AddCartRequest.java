package com.tananh.request;

public class AddCartRequest {

	private String Capacity;
	private String Color;
	private Long discountedPrice;
	public AddCartRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddCartRequest(String capacity, String color, Long discountedPrice) {
		super();
		Capacity = capacity;
		Color = color;
		this.discountedPrice = discountedPrice;
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
