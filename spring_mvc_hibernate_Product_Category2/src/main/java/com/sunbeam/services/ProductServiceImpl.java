package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;
	
	@Override
	public List<Product> getAllProductByPrice(double start, double end) {
		// TODO Auto-generated method stub
		
		return pdao.getAllProduct(start, end);
	}
	
	
}
