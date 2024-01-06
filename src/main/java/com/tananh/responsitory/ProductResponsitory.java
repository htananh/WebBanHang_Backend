package com.tananh.responsitory;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tananh.model.Product;

@Repository
public interface ProductResponsitory extends JpaRepository<Product, Long> {
	
	
	@Query("SELECT p FROM Product p " +
		       "WHERE (:brand IS NULL OR p.brand = :brand) " +
		       "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice)) " +
		       "ORDER BY " +
		       "CASE " +
		       "    WHEN :sort = 'lowtohight' THEN p.discountedPrice END ASC, " +
		       "    CASE " +
		       "    WHEN :sort = 'highttolow' THEN p.discountedPrice END DESC")
		List<Product> filterProduct(@Param("brand") String brand,
		                            @Param("minPrice") Long minPrice,
		                            @Param("maxPrice") Long maxPrice,
		                            @Param("sort") String sort);

	Product findProductByid(Long id);
	List<Product> findProductByBrand(String brand);
}
