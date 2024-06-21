package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
	@Column(unique = true)
	private String name;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "productCategory",
			cascade = CascadeType.ALL)
	
	private List<Product> products=new ArrayList<>();

	public Category(Long id, LocalDate createdOn, LocalDateTime updatedOn, String name, String description) {
		super(id, createdOn, updatedOn);
		this.name = name;
		this.description = description;
	}
	//
	public void addProduct(Product product)
	{
		this.products.add(product);
		product.setProductCategory(this);
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [id=" +getId()  +",name=" + name + ", description=" + description + "]";
	}
	
	
	

}
