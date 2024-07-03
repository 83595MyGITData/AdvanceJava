package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Reservation;
import com.sunbeam.entities.Room;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
	
	//@Query("select r.room  from Reservation r where r.room.availability=:true and r.checkOut<:check")
	//@Query("select r.room from Reservation r where r.checkOut<:check")
	@Query("select r  from Room r where r.id != ('select a.room from Reservation a where r.room.availability=:true and a.checkOut<:check')" )
	List <Room> availableRooms(LocalDate check);
	
	//@Query("select c from Category c left join fetch c.posts where c.id=:id")
	//Optional<Category> getCategoryAndPosts(Long id);
	
}
