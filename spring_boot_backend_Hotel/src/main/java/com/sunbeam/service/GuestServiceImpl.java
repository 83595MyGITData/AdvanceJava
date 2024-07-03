package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.dto.GuestDto;
import com.sunbeam.entities.Guest;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestDao guestDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public GuestDto addGuest(GuestDto dto) {
		// TODO Auto-generated method stub
		Guest guest=mapper.map(dto, Guest.class);
		Guest persistantGuest=guestDao.save(guest);
		return mapper.map(persistantGuest, GuestDto.class);
	}
	


}
