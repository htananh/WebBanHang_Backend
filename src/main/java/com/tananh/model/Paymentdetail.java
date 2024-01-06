package com.tananh.model;




public class Paymentdetail {

	private String paymentMethod;
	private String Status;
	private String paymentId;
	public Paymentdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
}
