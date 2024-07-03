package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.dto.RoomReqDto;
import com.sunbeam.service.ReservationServce;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationServce resService;
	
	public ReservationController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside "+getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> roomReservation(@RequestBody ReservationDto dto)
	{
		try {
			return ResponseEntity.ok(resService.reserveRoom(dto));
			
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
