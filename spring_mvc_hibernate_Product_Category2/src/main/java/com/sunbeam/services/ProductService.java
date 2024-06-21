package com.sunbeam.services;
import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductService {
	
	List<Product> getAllProductByPrice(double start,double end);
}
