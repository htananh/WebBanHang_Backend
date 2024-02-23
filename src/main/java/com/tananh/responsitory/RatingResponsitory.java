package com.tananh.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tananh.model.Rating;

public interface RatingResponsitory extends JpaRepository<Rating, Long>{

	@Query("SELECT r FROM Rating Where r.product.id=:productId")
	public List<Rating> getALLRating(@Param("productId") Long ProductId);
}
