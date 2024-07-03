package com.sunbeam.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sunbeam.entities.Role;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class UserRegisterRequestDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private double regAmount;
	private Role role;
	

}
