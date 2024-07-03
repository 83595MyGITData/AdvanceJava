package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.DateDto;
import com.sunbeam.dto.RoomReqDto;
import com.sunbeam.entities.Room;

public interface RoomService {

	RoomReqDto addRoom(RoomReqDto dto);
	List<Room> availableRoom(DateDto dto);
	
}