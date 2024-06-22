package com.sunbeam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.entities.Product;

public interface ProductService {
	
	List <Product> GetAllProducts();

}
