package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="products")
public class Product extends BaseEntity{
	
	@Column(name="name",length = 25,unique = true)
	private String name;
	
	@Column(name="avail_quantity")
	private int availQuantity;

	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	private Category productCategory;
	
	private double price;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name2, double price2, int quantity) {
		// TODO Auto-generated constructor stub
		this.name=name2;
		this.price=price2;
		this.availQuantity=quantity;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public int getAvailQuantity() {
		return availQuantity;
	}

	public void setAvailQuantity(int availQuantity) {
		this.availQuantity = availQuantity;
	}

	
	
}
