package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.GuestDao;
import com.sunbeam.dao.ReservationDao;
import com.sunbeam.dao.RoomDao;
import com.sunbeam.dto.DateDto;
import com.sunbeam.dto.ReservationDto;
import com.sunbeam.entities.Guest;
import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;
@Service
@Transactional
public class ReservationServeImpl implements ReservationServce {

	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private GuestDao guestDao;
	
	@Override
	public ReservationDto reserveRoom(ReservationDto dto) {
		// TODO Auto-generated method stub
		Reservation reservation=mapper.map(dto, Reservation.class);
		
		Room room=roomDao.findById(dto.getRoomId()).orElseThrow(()->(new RuntimeException("Invalid RoomId")));
		
		Guest guest=guestDao.findById(dto.getGuestId()).orElseThrow(()->(new RuntimeException("Invalid GuestId")));
		
		Reservation persistantReservation = reservationDao.save(reservation);
		
				
		if(room.isAvailability())
		{
			//reservation.setCheckIn(dto.getCheckIn());		
			reservation.setGuest(guest);
			reservation.setRoom(room);
			reservation.getRoom().setAvailability(false);//Making Room as unavailable
						
		}
		
		return mapper.map(persistantReservation, ReservationDto.class);
	}

	@Override
	public List<Room> availableRoom(DateDto dto) {
		Reservation reservation=mapper.map(dto, Reservation.class);
		//reservationDao.findBy
		return null;
	}
	

}
