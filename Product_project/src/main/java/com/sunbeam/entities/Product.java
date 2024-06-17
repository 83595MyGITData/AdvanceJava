package com.sunbeam.entities;

import javax.persistence.*;
@Entity
@Table(name="products")
public class Product {
//products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY)
//	,product name(unique)  , price , available quantity
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private  Long id;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Column(name="product_name",length = 25,unique = true)
	private String productName;
	
	private double price;
	
	@Column(name="avail_quantity")
	private int availQuantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Category category, String productName, double price, int availQuantity) {
		super();
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.availQuantity = availQuantity;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvail_Quantity() {
		return availQuantity;
	}

	public void setAvail_Quantity(int avail_Quantity) {
		this.availQuantity = avail_Quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", avail_Quantity=" + availQuantity + "]";
	}
	

}
