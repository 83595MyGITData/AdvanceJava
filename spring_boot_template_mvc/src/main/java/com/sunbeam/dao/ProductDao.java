package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Product;
import com.sunbeam.entities.Category;
import java.util.List;
@Repository
public interface ProductDao extends JpaRepository<Product,Long>  {
	
 List<Product> findAll();


}
