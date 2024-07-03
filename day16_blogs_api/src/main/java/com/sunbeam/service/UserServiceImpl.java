package com.sunbeam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.AuthenticationException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.AddressDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AddressDto;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.CategoryPostDTO;
import com.sunbeam.dto.SearchByCityDto;
import com.sunbeam.dto.SearchByCityRespDto;
import com.sunbeam.dto.UserRegisterRequestDto;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// depcy
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AddressDao addressDao;

	@Override
	public UserRespDTO authenticateUser(AuthRequest dto) {
		// 1.invoke dao 's method
		User user = userDao.findByEmailAndPassword(
				dto.getEmail(), dto.getPwd())
				.orElseThrow(() -> 
				new AuthenticationException("Invalid Email or Password !!!!!!"));
		//valid login -user : persistent -> entity -> dto
		return mapper.map(user, UserRespDTO.class);
	}

	@Override
	public UserRespDTO registerUser(UserRegisterRequestDto dto) {
		
		User user= mapper.map(dto, User.class); //deserliase
		User PersistantUser=userDao.save(user);
		
		
		return mapper.map(PersistantUser, UserRespDTO.class);
	}

	@Override
	public AddressDto addAddress(AddressDto dto) {
		
		User  user = userDao.findById(dto.getUserId()).orElseThrow(() -> 
		new AuthenticationException("Invalid User !!!!!!"));
		Address address=mapper.map(dto,Address.class);
		user.setUserAddress(address);
		Address persistantAddress=addressDao.save(address);
		
		return mapper.map(persistantAddress, AddressDto.class);
	}

	@Override
	public List <User> searchByCity(String city) {

		
		 List <User> userList=  userDao.getUserFromCity(city);
		 //set Address
	//	new SearchByCityRespDto().setUserList(userList);
		
		 //return null;
		return userList;
	}
	

}
