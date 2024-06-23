package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Product;
import com.sunbeam.services.ProductService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	public ProductController() {
		// TODO Auto-generated constructor stub
		System.out.println("In Constructor" +getClass());
	}
	
	@GetMapping
	public List<Product> renderAllProducts()
	{
		System.out.println("Inside TestController");
		return prodService.getAllProducts();
		
	}
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody Product prod)
	{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(prodService.addProduct(prod));
		}
		catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<?> getProduct(@PathVariable Long pid )
	{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(prodService.getProduct(pid));
		}
		catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long pid)
	{
		try {
			return ResponseEntity.ok(prodService.deleteProductbyId(pid));
		}
		catch(RuntimeException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	@PutMapping("/{pid}")
	public ResponseEntity<?> updateProductById(@PathVariable Long pid,@RequestBody Product product)
	{
		try {
			return ResponseEntity.ok(prodService.updateProductbyId(pid, product));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
