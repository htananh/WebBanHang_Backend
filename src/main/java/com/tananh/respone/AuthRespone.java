package com.tananh.respone;

public class AuthRespone {

	private String jwt;
	private String message;
	
	public AuthRespone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthRespone(String jwt, String message) {
		super();
		this.jwt = jwt;
		this.message = message;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
