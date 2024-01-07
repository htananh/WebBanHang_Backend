package com.tananh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tananh.exception.CartItemException;
import com.tananh.exception.UserException;
import com.tananh.model.Cart;
import com.tananh.model.CartItem;
import com.tananh.model.Product;
import com.tananh.model.User;
import com.tananh.responsitory.CartItemResponsitory;

@Service
public class CartItemServiceImplementation implements CartItemService{

	@Autowired
	private CartItemResponsitory cartItemResponsitory;
	
	@Autowired
	private UserService userService;
	
	@Override
	public CartItem createCartItem(CartItem cartItem) {
		cartItem.setQuantity(1);
		cartItem.setDiscountedPrice(cartItem.getQuantity()*cartItem.getDiscountedPrice());
		CartItem item = cartItemResponsitory.save(cartItem);
		
		return item;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws UserException, CartItemException {
		CartItem Item = findCartItemById(id);
		if(userId.equals(Item.getUserId()))
		{
			Item.setQuantity(cartItem.getQuantity());
			Item.setDiscountedPrice(Item.getQuantity()*Item.getDiscountedPrice());
		}
		
		return cartItemResponsitory.save(Item);
	}

	@Override
	public String removeCartItem(Long userId, Long cartItemId) throws UserException,CartItemException {
		CartItem cartItem = findCartItemById(cartItemId);
		
		User user = userService.findUserById(cartItem.getUserId());
		User qeqUser = userService.findUserById(userId);
		if(user.getId().equals(qeqUser.getId()))
		{
			cartItemResponsitory.delete(cartItem);
		}
		
				
		return "Đã xóa sản phẩm thành công";
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException{
		Optional<CartItem> cartItem = cartItemResponsitory.findById(cartItemId);
		if(cartItem.isPresent())
		{
			return cartItem.get();
		}
		throw new CartItemException("Không tìm thấy sản phẩm với id -"+cartItemId);
	}

	@Override
	public CartItem isCartItemExist(Long userId, Product product, Cart card, String Capacity) {
		CartItem cartItem = cartItemResponsitory.isCartItemExist(userId, card, Capacity, product);
		return cartItem;
	}

	
}
