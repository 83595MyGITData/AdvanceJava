package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
	
	void insertData(Product p1);
	Product getDataByProdId(Long id);
	List <Product> getDataBetweenDates(double startPrice,double endPrice);
	List <Product> getDataBetweenPriceAndCategory(double sPrice,double ePrice,Category cat);
	String getDiscountedProductsByPrice(Category cat,double discount);
	String purchaseProduct(Long id,int reqquantity);
	String deleteProductByName(String ProdName);
}
