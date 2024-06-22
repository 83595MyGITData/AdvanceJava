package com.sunbeam.service;

import com.sunbeam.entities.User;

public interface UserService {
	User getUserByEmailandPass(String email,String Pass);
}
