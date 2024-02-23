package com.tananh.service;

import java.util.List;

import com.tananh.exception.productException;
import com.tananh.model.Review;
import com.tananh.model.User;
import com.tananh.request.ReviewRequest;

public interface ReviewService {
	public Review CreateReview (ReviewRequest req, User user) throws productException;
	
	public List<Review> getALLReview(Long productId)throws productException;
}
