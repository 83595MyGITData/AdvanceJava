package com.sunbeam.dto;

import java.util.List;

import com.sunbeam.entities.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class SearchByCityRespDto {

	private String city;
	private List<SearchByCityRespDto> userList;

}
