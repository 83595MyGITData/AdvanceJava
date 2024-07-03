package com.sunbeam.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;
//Unit test for testing a DAL layer method
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class availRoom {
	
	@Autowired
	private ReservationDao reserveService;
	
	@Test
	void testAvailableRooms() {
		//ReservationDto dto=
		String date ="2024-06-26";
		LocalDate a=LocalDate.parse(date);
		List<Room> list=reserveService.availableRooms(a);

		list.forEach(System.out::println);
		
		assertEquals(4,list.size());
		
	
	}

	
}
