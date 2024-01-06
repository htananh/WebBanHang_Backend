package com.tananh.model;

import java.util.ArrayList;
import java.util.Date;
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
	private Long discountedPrice;
	
	@Column(name="price")
	private Long price;
	
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
	
//	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//	private List<orderItem> orderItem = new ArrayList<>();
	
	@Column(name="num_rating")
	private int numRating;
	
	
	private Date createAt;

	private String color;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Product(Long id, String imgUrl, String brand, String title, Long discountedPrice, Long price,
			String discountPersent, List<String> arrImg, int quantity, List<Type> type, List<Review> review,
			List<Rating> rating, int numRating, Date createAt, String color) {
		super();
		this.id = id;
		this.imgUrl = imgUrl;
		this.brand = brand;
		this.title = title;
		this.discountedPrice = discountedPrice;
		this.price = price;
		this.discountPersent = discountPersent;
		this.arrImg = arrImg;
		this.quantity = quantity;
		this.type = type;
		this.review = review;
		this.rating = rating;
		this.numRating = numRating;
		this.createAt = createAt;
		this.color = color;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDiscountPersent() {
		return discountPersent;
	}

	public void setDiscountPersent(String discountPersent) {
		this.discountPersent = discountPersent;
	}

	public List<String> getArrImg() {
		return arrImg;
	}

	public void setArrImg(List<String> arrImg) {
		this.arrImg = arrImg;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Type> getType() {
		return type;
	}

	public void setType(List<Type> type) {
		this.type = type;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	public int getNumRating() {
		return numRating;
	}

	public void setNumRating(int numRating) {
		this.numRating = numRating;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
	
}
