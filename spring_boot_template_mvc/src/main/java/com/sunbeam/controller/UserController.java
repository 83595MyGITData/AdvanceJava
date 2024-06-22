package com.sunbeam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;
import com.sunbeam.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService usrService;
	
	public UserController() {

		System.out.println("Inside -  "+getClass());
	}

	@GetMapping("/login")
	public String UserLogin()
	{		
		return "/user/login";	
	}
	
	@PostMapping("/login")
	public String authenticateUser(@RequestParam String em,@RequestParam String pass,HttpSession session)
	{
		try {
		User user= usrService.getUserByEmailandPass(em, pass);
		session.setAttribute("user", user);
		if(user.getRole()==Role.BLOGGER) {
			System.out.println("User::  " + user);
		return "/user/blogger/home";}
		}
		catch (RuntimeException e) {
		
			e.printStackTrace();
		}
		return "/user/login";
		
	}

}
