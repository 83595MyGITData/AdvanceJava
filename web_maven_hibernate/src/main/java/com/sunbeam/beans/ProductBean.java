package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.ProductDao;
import com.sunbeam.daos.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class ProductBean {
	
	private String name;
	private double price;
	private int quantity;
	private long categoryId;
	private long productId;

	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}

	private ProductDao productDao;
	
	public ProductBean() {
		// TODO Auto-generated constructor stub
		productDao=new ProductDaoImpl();
		System.out.println("Product bean Created");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String addNewProduct() {
		System.out.println("in add product" +categoryId);
		//1.create product instance
		Product product = new Product(name,price,quantity);
		//invoke daos method for saving products details in db
		return productDao.addProduct(categoryId, product);
	}
	public List<Product> allProducts() {
		
		return productDao.getAllProducts();	
	}
	
	public String purchaseProduct() {
		System.out.println("in purchase " + quantity + " " + productId);
		return productDao.purchaseProduct(productId, quantity);
	}	
	

}
