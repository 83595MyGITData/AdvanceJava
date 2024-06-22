package com.sunbeam.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.UserDao;
import com.sunbeam.entities.User;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;

	public User getUserByEmailandPass(String email, String Pass) {
		// TODO Auto-generated method stub
		return userdao.findByEmailAndPassword(email, Pass).orElseThrow();
	}

	
	

}
