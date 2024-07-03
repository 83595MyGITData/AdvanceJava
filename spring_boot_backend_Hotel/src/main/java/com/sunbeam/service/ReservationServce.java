package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.DateDto;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.entities.Room;

public interface ReservationServce {
	
	public ReservationDto reserveRoom(ReservationDto dto);
	
	public List<Room> availableRoom (DateDto dto);
	

}
