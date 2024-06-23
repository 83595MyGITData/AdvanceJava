package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	
	Optional<Product> findById(Long Id);
	
	

}
