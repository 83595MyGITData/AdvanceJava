package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;
	@Override
	public List<Product> GetAllProducts() {
		
		return dao.findAll();
	}

}
