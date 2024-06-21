package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	public TestController()
	{
		System.out.println("in ctr "+getClass());
	}
	@RequestMapping("/")
	public String renderHomepage()
	{   System.out.println("inside render page");
		return "/index";
	}
}
