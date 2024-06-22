package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService prodser;
	@GetMapping("/display")
	public String renderProduct(Model map)
	{
		map.addAttribute("prod_list",prodser.GetAllProducts());
		
		return "/product/list";
		
	}
}
