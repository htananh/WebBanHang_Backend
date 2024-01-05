package com.tananh.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String review;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private LocalDateTime CreateAt;

	
	
	
	public Review() {
		
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreateAt() {
		return CreateAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		CreateAt = createAt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Review(Long id, String review, User user, Product product, LocalDateTime createAt) {
		super();
		Id = id;
		this.review = review;
		this.user = user;
		this.product = product;
		CreateAt = createAt;
	}
	
	
}
