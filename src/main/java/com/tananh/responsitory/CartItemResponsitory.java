package com.tananh.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tananh.model.Cart;
import com.tananh.model.CartItem;

@Repository
public interface CartItemResponsitory extends JpaRepository<CartItem, Long> {

	@Query("SELECT ci FROM CartItem ci " +
	        "WHERE ci.userId = :userId AND ci.cart = :cart AND ci.Capacity = :Capacity AND ci.id = :cartItemId")
	CartItem isCartItemExist(@Param("userId") Long userId,
	                          @Param("cart") Cart cart,
	                          @Param("Capacity") String Capacity,
	                          @Param("cartItemId") Long cartItemId);

	
}
