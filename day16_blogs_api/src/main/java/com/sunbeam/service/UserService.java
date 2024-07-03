package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AddressDto;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.SearchByCityDto;
import com.sunbeam.dto.SearchByCityRespDto;
import com.sunbeam.dto.UserRegisterRequestDto;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;

public interface UserService {
//user signin
	UserRespDTO authenticateUser(AuthRequest dto);
	
	UserRespDTO registerUser(UserRegisterRequestDto dto);
	
	AddressDto addAddress(AddressDto dto);
	
	List <User> searchByCity (String city);
}
