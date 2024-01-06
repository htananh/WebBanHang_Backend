package com.tananh.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tananh.exception.productException;
import com.tananh.model.Product;
import com.tananh.request.CreateProductRequest;
import com.tananh.responsitory.ProductResponsitory;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	ProductResponsitory productResponsitory;
	
	@Override
	public Product createProduct(CreateProductRequest req) {
		Product product = new Product();
		
		product.setImgUrl(req.getImageURL());
		product.setBrand(req.getBrand());
		product.setTitle(req.getTitle());
		product.setColor(req.getColor());
		product.setDiscountedPrice(req.getDiscountedPrice());
		product.setPrice(req.getPrice());
		product.setArrImg(req.getArrImg());
		product.setType(req.getType());
		product.setDiscountPersent(req.getDiscountPersent());
		product.setQuantity(req.getQuantity());
		
		Product saveProduct = productResponsitory.save(product);
		return saveProduct;
	}

	@Override
	public String deleteProduct(Long id) throws productException {
		Product product = productResponsitory.findProductByid(id);
		product.getType().clear();
		productResponsitory.delete(product);
		return "Đã xóa thành công";
	}

	@Override
	public Product updateProduct(Long id, Product product) throws productException {
		Product productFinded = productResponsitory.findProductByid(id);
		if(product.getQuantity()!=0)
		{
			productFinded.setQuantity(product.getQuantity());
		}
		Product savedProduct=productResponsitory.save(productFinded);
		return savedProduct;
	}

	@Override
	public Product findProductById(Long id) throws productException {
		Optional<Product> product= productResponsitory.findById(id);
		if(product.isPresent())
		{
			return product.get();
		} throw new productException("Không tìm thấy sản phẩm với id="+id);
	}

	@Override
	public List<Product> findProductByBrand(String brand) throws productException {
		List<Product> product = productResponsitory.findProductByBrand(brand);
		return product;
	}

	@Override
	public Page<Product> getAllProduct(String brand, List<String> color, Long minPrice, Long maxPrice, String sort,
			Integer pageNumber, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		List<Product> product = productResponsitory.filterProduct(brand, minPrice, maxPrice, sort);
		
		if(!color.isEmpty()) {
			product = product.stream()
					 .filter(p -> color.stream().anyMatch(c -> c.equalsIgnoreCase(p.getColor())))
		                .collect(Collectors.toList());
		}
		int startIndex=(int) pageRequest.getOffset();
		int endIndex=Math.min(startIndex+pageRequest.getPageSize(), product.size());
		List<Product> pageContent = product.subList(startIndex, endIndex);
		Page<Product> filteredProduct = new PageImpl<>(pageContent,pageRequest,product.size());
	
		return filteredProduct;
	}

}
