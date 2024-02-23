package com.tananh.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tananh.exception.productException;
import com.tananh.model.Product;
import com.tananh.model.Rating;
import com.tananh.model.User;
import com.tananh.request.RatingRequest;
import com.tananh.responsitory.RatingResponsitory;

@Service
public class RatingServiceImplementation implements RatingService{

	@Autowired private RatingResponsitory ratingResponsitory;
	@Autowired private ProductService productService;
	
	@Override
	public Rating createRating(RatingRequest req, User user) throws productException {
		Product product = productService.findProductById(req.getProductId());
		
		Rating rating = new Rating();
		
		rating.setProduct(product);
		rating.setRating(req.getRating());
		rating.setUser(user);
		rating.setCreateAt(LocalDateTime.now());
		return ratingResponsitory.save(rating);
		
	}

	@Override
	public List<Rating> getProductRating(Long productId) throws productException {
		// TODO Auto-generated method stub
		return ratingResponsitory.getALLRating(productId);
	}

}
