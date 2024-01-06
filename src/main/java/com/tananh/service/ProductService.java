package com.tananh.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tananh.exception.productException;
import com.tananh.model.Product;
import com.tananh.request.CreateProductRequest;

public interface ProductService {

	public Product createProduct(CreateProductRequest req);
		
	public String deleteProduct(Long id) throws productException;
	
	public Product updateProduct ( Long id, Product product) throws productException;
	
	public Product findProductById (Long id) throws productException;
	
	public List<Product> findProductByBrand( String brand) throws productException;
	
	public Page<Product> getAllProduct(String brand, List<String> color, Long minPrice, Long maxPrice, 
			String sort, Integer pageNumber, Integer pageSize);
}
