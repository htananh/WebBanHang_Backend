package com.tananh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tananh.exception.productException;
import com.tananh.model.Cart;
import com.tananh.model.CartItem;
import com.tananh.model.Product;
import com.tananh.model.User;
import com.tananh.request.AddCartRequest;
import com.tananh.responsitory.CartRespository;

@Service
public class CartServiceImplementation implements CartService {

	@Autowired
	private CartRespository cartRespository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	@Override
	public Cart createCart(User user) {
		Cart cart = new Cart();
		cart.setUser(user);
		return cartRespository.save(cart);
	}

	@Override
	public String addItemCart(Long userid, AddCartRequest req) throws productException{
		
		Cart cart = cartRespository.findByUserId(userid);
		Product product = productService.findProductById(req.getProductId());
		String Capacity =req.getCapacity();
		CartItem cartItemisExits = cartItemService.isCartItemExist(userid, product, cart, Capacity);
		
		if(cartItemisExits==null) {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setCart(cart);
			cartItem.setCapacity(req.getCapacity());
			cartItem.setDiscountedPrice(req.getDiscountedPrice());
			cartItem.setColor(req.getColor());
			cartItem.setUserId(userid);
			
			CartItem CartItemCreated =cartItemService.createCartItem(cartItem);
			cart.getCartItem().add(CartItemCreated);
		}
		return "đã thêm vào giỏ hàng";
	}

	@Override
	public Cart findUserCart(Long userI) {
		Cart cart = cartRespository.findByUserId(userI);
		
		Long totalDiscountPrice=0L;
		int totalItem=0;
		for(CartItem cartItem : cart.getCartItem())
		{
			totalItem=totalItem+cartItem.getQuantity();
			totalDiscountPrice=totalDiscountPrice+cartItem.getDiscountedPrice();
		}
		cart.setPriceTotal(totalDiscountPrice);
		cart.setTotalItem(totalItem);
		return cartRespository.save(cart);
	}

}
