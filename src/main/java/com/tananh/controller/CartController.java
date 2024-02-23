package com.tananh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tananh.exception.UserException;
import com.tananh.model.Cart;
import com.tananh.model.User;
import com.tananh.request.AddCartRequest;
import com.tananh.service.CartService;
import com.tananh.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired CartService cartService;
	@Autowired UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCart(@RequestHeader("Authentication")String jwt)
			throws UserException{
		User user = userService.findUserByJWT(jwt);
		Cart cart = cartService.findUserCart(user.getId());
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	};
	
//	@PutMapping("/add")
//	public ResponseEntity<ApiResponse> addToCart(@RequestBody AddCartRequest req
//			,@RequestHeader("Authentication")String jwt)
//			throws UserException{
//		User user = userService.findUserByJWT(jwt);
//		cartService.addItemCart(user.getId(), req);
//		ApiResponse res = new ApiResponse();
//		res.setMessage("đã thêm thành công");
//		res.setStatus(true);
//		return new ResponseEntity<>(res, HttpStatus.OK);

//	}
}
