
package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.services.ProductService;

@Controller
@RequestMapping("/posts")
public class GetProduct {
	@Autowired
	private ProductService pd;
	
	public GetProduct()
	{
		System.out.println("inside controller product");
	}
	
	@GetMapping("/view")
	public String getProductDetails(Model map, @RequestParam Long n1, @RequestParam Long n2)
	{
		map.addAttribute("pd_list",pd.getAllProductByPrice(n1, n2));
		return "/posts/prod";
	}
}
