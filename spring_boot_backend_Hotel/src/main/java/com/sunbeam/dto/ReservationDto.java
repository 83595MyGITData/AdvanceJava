package com.sunbeam.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class ReservationDto {
	
	private LocalDate checkIn;
	private LocalDate checkOut;
	private double totalPrice;
	private Long roomId;
	private Long guestId;
	

}
