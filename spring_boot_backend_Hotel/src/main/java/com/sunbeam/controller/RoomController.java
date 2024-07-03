package com.sunbeam.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.RoomReqDto;
import com.sunbeam.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	@Autowired
	private ModelMapper modelMapper;
	
	public RoomController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside "+getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addRoom(@RequestBody RoomReqDto dto)
	{
		try {
			return ResponseEntity.ok(roomService.addRoom(dto));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
