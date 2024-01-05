package com.tananh.model;

import jakarta.persistence.Column;

public class Type {

	  private String capacity;
      private int quantity;
      @Column(name="discounted_price")
      private int discountedPrice;
      
      
     
	public Type() {
	
		// TODO Auto-generated constructor stub
	}
	public Type(String capacity, int quantity, int discountedPrice) {
		super();
		this.capacity = capacity;
		this.quantity = quantity;
		this.discountedPrice = discountedPrice;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
      
      
}
