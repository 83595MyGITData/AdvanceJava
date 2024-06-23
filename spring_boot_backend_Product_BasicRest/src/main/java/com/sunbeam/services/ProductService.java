package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductService {
	
	List <Product> getAllProducts();
	Product addProduct(Product p);
	Product getProduct(Long id);
	
	String deleteProductbyId(Long id);
	
	String updateProductbyId(Long id,Product prod);
}
