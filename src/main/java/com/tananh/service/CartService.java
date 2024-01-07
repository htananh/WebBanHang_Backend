package com.tananh.service;

import com.tananh.model.Cart;

import com.tananh.model.User;
import com.tananh.request.AddCartRequest;

public interface CartService {
	public Cart createCart(User user);
	
	public String addItemCart(Long userid, AddCartRequest req);
	
	public Cart findUserCart(Long userI);
	
	
}
