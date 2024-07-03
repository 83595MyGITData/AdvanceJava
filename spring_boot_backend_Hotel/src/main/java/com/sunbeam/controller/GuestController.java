package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.GuestDto;
import com.sunbeam.service.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	public GuestController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside "+getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addGuest(@RequestBody GuestDto dto)
	{
		try {
			return ResponseEntity.ok(guestService.addGuest(dto));
			
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
