package com.tananh.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tananh.model.Cart;

@Repository
public interface CartRespository extends JpaRepository<Cart, Long>{

	Cart findByUserId(Long userId);
}
