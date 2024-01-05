package com.tananh.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String moblie;
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	
	@Embedded
	@ElementCollection
	@CollectionTable(name="payment_infomation", joinColumns = @JoinColumn(name="user_id"))
	private List<PaymentInfomation> paymentInfomation = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Review> review = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Rating> rating = new ArrayList<>();

	
	
	public User() {
		
		// TODO Auto-generated constructor stub
	}

	

	public User(Long id, String firstName, String lastName, String email, String role, String moblie, String password,
			List<Address> address, List<PaymentInfomation> paymentInfomation, List<Review> review,
			List<Rating> rating) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.moblie = moblie;
		this.password = password;
		this.address = address;
		this.paymentInfomation = paymentInfomation;
		this.review = review;
		this.rating = rating;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMoblie() {
		return moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<PaymentInfomation> getPaymentInfomation() {
		return paymentInfomation;
	}

	public void setPaymentInfomation(List<PaymentInfomation> paymentInfomation) {
		this.paymentInfomation = paymentInfomation;
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
	
	
	
}
