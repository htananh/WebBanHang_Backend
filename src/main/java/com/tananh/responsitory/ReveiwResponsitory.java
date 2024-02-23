package com.tananh.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.tananh.model.Review;

public interface ReveiwResponsitory extends JpaRepository<Review, Long> {
	@Query("SELECT r FROM Review Where r.product.id=:productId")
	public List<Review> getALLReview(@Param("productId") Long ProductId);
}
