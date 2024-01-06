package com.tananh.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class OrderPr {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="order_id")
	private String orderId;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	private List<orderItem> orderItems = new ArrayList<>();
	
	@OneToOne
	private Address addressShipping;
	
	@Embedded
	private Paymentdetail paymentdetail = new Paymentdetail();
	
	private LocalDateTime orderDate;
	
	private LocalDate deliveryDate;
	
	private double totalPrice;
	private double toltalDiscountPrice;
	
	private String orderStatus;
	
	private int totalItme;
	private LocalDateTime createAt;
	public OrderPr() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public OrderPr(Long id, String orderId, User user, List<orderItem> orderItems, Address addressShipping,
			Paymentdetail paymentdetail, LocalDateTime orderDate, LocalDate deliveryDate, double totalPrice,
			double toltalDiscountPrice, String orderStatus, int totalItme, LocalDateTime createAt) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.user = user;
		this.orderItems = orderItems;
		this.addressShipping = addressShipping;
		this.paymentdetail = paymentdetail;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.totalPrice = totalPrice;
		this.toltalDiscountPrice = toltalDiscountPrice;
		this.orderStatus = orderStatus;
		this.totalItme = totalItme;
		this.createAt = createAt;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<orderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<orderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Paymentdetail getPaymentdetail() {
		return paymentdetail;
	}


	public void setPaymentdetail(Paymentdetail paymentdetail) {
		this.paymentdetail = paymentdetail;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getToltalDiscountPrice() {
		return toltalDiscountPrice;
	}
	public void setToltalDiscountPrice(double toltalDiscountPrice) {
		this.toltalDiscountPrice = toltalDiscountPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getTotalItme() {
		return totalItme;
	}
	public void setTotalItme(int totalItme) {
		this.totalItme = totalItme;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public Address getAddressShipping() {
		return addressShipping;
	}

	public void setAddressShipping(Address addressShipping) {
		this.addressShipping = addressShipping;
	}
	
	
}
