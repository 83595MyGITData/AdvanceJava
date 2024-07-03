package com.sunbeam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

@Entity
@Table(name="rooms")



public class Room extends BaseEntity {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_number",unique = true)
	private int roomNumber;
	//@Enumerated(EnumType.STRING)
	private TYPE type;
	private double price;
	private boolean availability;
	
}
