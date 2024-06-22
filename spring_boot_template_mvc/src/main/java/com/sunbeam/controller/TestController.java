package com.sunbeam.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
	public TestController() {
		System.out.println("In test controller  "+getClass());
		// TODO Auto-generated constructor stub
	}
	
@GetMapping("/")
	public String renderIndexPage(Model map)
	{
		System.out.println("in render index page "+map);
		map.addAttribute("ts",LocalDateTime.now());
		return "/index";//AVN - /WEB-INF/views/index.jsp
	}

}
