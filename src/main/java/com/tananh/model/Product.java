package com.tananh.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="img_url")
	private String imgUrl;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="title")
	private String title;
	
	@Column(name="discounted_price")
	private String discountedPrice;
	
	@Column(name="price")
	private String price;
	
	@Column(name="discount_persent")
	private String discountPersent;
	
	@Column(name="arr_img")
	private List<String> arrImg;
	
	@Column(name="quantity")
	private int quantity;
	
	@Embedded
	@ElementCollection
	@CollectionTable(name="type", joinColumns = @JoinColumn(name="product_id"))
	private List<Type> type = new ArrayList<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> review = new ArrayList<>();
	
	@OneToMany(mappedBy = "product", cascade= CascadeType.ALL)
	private List<Rating> rating = new ArrayList<>();
	
	@Column(name="num_rating")
	private int numRating;
}
