package com.tananh.service;

import com.tananh.exception.CartItemException;
import com.tananh.exception.UserException;
import com.tananh.model.Cart;
import com.tananh.model.CartItem;
import com.tananh.model.Product;

public interface CartItemService {

	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem )
			throws UserException,CartItemException;
	
	public String removeCartItem(Long userId, Long cartItemId) throws UserException,CartItemException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
	public CartItem isCartItemExist(Long userId, Product product, Cart card, String Capacity);
	
}
