package com.tananh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String fullName;
	private String provinces;
	private String district;
	private String ward;
	private String streetAddress;
	private String moblie;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	public Address() {
		
		// TODO Auto-generated constructor stub
	}







	public Address(Long id, String fullName, String provinces, String district, String ward, String streetAddress,
			String moblie, User user) {
		super();
		Id = id;
		this.fullName = fullName;
		this.provinces = provinces;
		this.district = district;
		this.ward = ward;
		this.streetAddress = streetAddress;
		this.moblie = moblie;
		this.user = user;
	}







	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	


	public String getFullName() {
		return fullName;
	}







	public void setFullName(String fullName) {
		this.fullName = fullName;
	}







	public String getProvinces() {
		return provinces;
	}



	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getWard() {
		return ward;
	}



	public void setWard(String ward) {
		this.ward = ward;
	}



	public String getStreetAddress() {
		return streetAddress;
	}



	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}



	public String getMoblie() {
		return moblie;
	}



	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	
}
