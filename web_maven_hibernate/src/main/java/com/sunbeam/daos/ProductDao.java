package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Product;

public interface ProductDao 
{
	
	public String addProduct(Long categoryId,Product newProduct);
	public String purchaseProduct(Long productId,int quant);
	public List<Product> getAllProducts();

}
