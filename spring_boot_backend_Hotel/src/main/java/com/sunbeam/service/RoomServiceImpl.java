package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.DateDto;
import com.sunbeam.dto.RoomReqDto;
import com.sunbeam.entities.Room;

@Service
@Transactional


public class RoomServiceImpl implements RoomService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoomDao roomDao;
	
	@Override
	public RoomReqDto addRoom(RoomReqDto dto) {
		Room room=modelMapper.map(dto, Room.class);
		Room persistantRoom=roomDao.save(room);
		return modelMapper.map(persistantRoom, RoomReqDto.class);
	}

	@Override
	public List<Room> availableRoom(DateDto dto) {
		
		Room room=modelMapper.map(dto, Room.class);
		
		
		return null;
	}

	
}
