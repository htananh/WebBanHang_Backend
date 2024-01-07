package com.tananh.service;

import com.tananh.exception.productException;
import com.tananh.model.Cart;

import com.tananh.model.User;
import com.tananh.request.AddCartRequest;

public interface CartService {
	public Cart createCart(User user);
	
	public String addItemCart(Long userid, AddCartRequest req) throws productException;
	
	public Cart findUserCart(Long userI);
	
	
}
