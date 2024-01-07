package com.tananh.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private Cart cart;
	
	@OneToMany
	private Product product;
	
	private String color;
	private String Capacity;
	
	private Long discountedPrice;
	
	private int quantity;

	private Long userId;
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	






	public CartItem(Long id, Cart cart, Product product, String color, String capacity, Long discountedPrice,
			int quantity, Long userId) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.color = color;
		Capacity = capacity;
		this.discountedPrice = discountedPrice;
		this.quantity = quantity;
		this.userId = userId;
	}







	public String getColor() {
		return color;
	}







	public void setColor(String color) {
		this.color = color;
	}







	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCapacity() {
		return Capacity;
	}

	public void setCapacity(String capacity) {
		Capacity = capacity;
	}

	public Long getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
