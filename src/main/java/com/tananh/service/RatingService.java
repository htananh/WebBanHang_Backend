package com.tananh.service;

import java.util.List;

import com.tananh.exception.productException;
import com.tananh.model.Rating;
import com.tananh.model.User;
import com.tananh.request.RatingRequest;

public interface RatingService {
	public Rating createRating (RatingRequest req, User user) throws productException;
	
	public List<Rating> getProductRating (Long productId)throws productException;
}
