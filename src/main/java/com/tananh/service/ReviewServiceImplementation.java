package com.tananh.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tananh.exception.productException;
import com.tananh.model.Product;
import com.tananh.model.Review;
import com.tananh.model.User;
import com.tananh.request.ReviewRequest;
import com.tananh.responsitory.RatingResponsitory;
import com.tananh.responsitory.ReveiwResponsitory;

@Service
public class ReviewServiceImplementation implements ReviewService{
	@Autowired private ReveiwResponsitory reveiwResponsitory;
	@Autowired private ProductService productService;
	@Override
	public Review CreateReview(ReviewRequest req, User user) throws productException {
		Product product = productService.findProductById(req.getProductId());
		
		Review review = new Review();
		
		review.setReview(req.getReview());
		review.setProduct(product);
		review.setUser(user);
		review.setCreateAt(LocalDateTime.now());
		return reveiwResponsitory.save(review);
	}

	@Override
	public List<Review> getALLReview(Long productId) throws productException {
		// TODO Auto-generated method stub
		return reveiwResponsitory.getALLReview(productId);
	}

}
