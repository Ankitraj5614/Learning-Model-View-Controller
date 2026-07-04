package com.Learning.service;

import org.springframework.stereotype.Service;

import com.Learning.entities.User;

@Service
public interface UserService {
		//to save data user
	User saveUser(User user);
	//to view all users
	
}
