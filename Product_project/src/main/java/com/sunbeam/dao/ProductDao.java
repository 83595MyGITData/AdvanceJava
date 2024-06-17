package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao {
	
	void insertData(Product p1);
	Product getDataByProdId(Long id);

}
