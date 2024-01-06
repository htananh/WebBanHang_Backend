package com.tananh.request;
import com.tananh.model.Type;
import java.util.*;

public class CreateProductRequest {
	private Long id;
	private String brand;
	private String title;
	private String imageURL;
	private String color;
	private Long discountedPrice;
	private Long price;
	private String discountPersent;
	private int quantity;
	private List<String> arrImg;
	private List<Type> Type = new ArrayList<>();
	public CreateProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateProductRequest(Long id, String brand, String title, String imageURL, String color,
			Long discountedPrice, Long price, String discountPersent, int quantity, List<String> arrImg,
			List<com.tananh.model.Type> type) {
		super();
		this.id = id;
		this.brand = brand;
		this.title = title;
		this.imageURL = imageURL;
		this.color = color;
		this.discountedPrice = discountedPrice;
		this.price = price;
		this.discountPersent = discountPersent;
		this.quantity = quantity;
		this.arrImg = arrImg;
		Type = type;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<String> getArrImg() {
		return arrImg;
	}
	public void setArrImg(List<String> arrImg) {
		this.arrImg = arrImg;
	}
	public List<Type> getType() {
		return Type;
	}
	public void setType(List<Type> type) {
		Type = type;
	}

	
	
}
