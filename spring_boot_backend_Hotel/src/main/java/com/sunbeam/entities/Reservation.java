package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

@Table(name="reservations")

public class Reservation extends BaseEntity {
	
	@Column(name = "checkin")
	private LocalDate checkIn;
	@Column(name = "checkout")
	private LocalDate checkOut;
	@Column(name = "total_price")
	private double totalPrice;
	
	//Reservation *-->1 Room
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	//Reservation*-->1 Guest
	@ManyToOne
	@JoinColumn(name = "guest_id")
	private Guest guest;
	
	public Reservation() {
		System.out.println("Inside "+getClass());
		// TODO Auto-generated constructor stub
	}
	

}
