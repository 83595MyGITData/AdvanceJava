package com.sunbeam.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class GuestDto {

	private String firstName;
	private String lastName;
	private LocalDate dob;

}
