package com.tananh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PaymentInfomation {

	@Column(name="cardholder_name")
	private String cardholderName;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="expiration_date")
	private String exprirationDate;
	
	@Column(name="cvv")
	private String cvv;
	
}
