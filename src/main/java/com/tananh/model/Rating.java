package com.tananh.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
	
	private Double rating;
	
	private LocalDateTime CreateAt;

	
	public Rating() {
		
		// TODO Auto-generated constructor stub
	}





	public Rating(Long id, User user, Product product, Double rating, LocalDateTime createAt) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.rating = rating;
		CreateAt = createAt;
	}





	public Product getProduct() {
		return product;
	}





	public void setProduct(Product product) {
		this.product = product;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public LocalDateTime getCreateAt() {
		return CreateAt;
	}


	public void setCreateAt(LocalDateTime createAt) {
		CreateAt = createAt;
	}
	
	
}
