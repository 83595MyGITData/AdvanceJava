package com.sunbeam.dto;

import com.sunbeam.entities.TYPE;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RoomReqDto {
	
	
	private int roomNumber;
	private TYPE type;
	private double price;
	private boolean availability;
	
//	public void setPrice(double price) {
//		this.price = type.getPri();
//	}
	
	

}
