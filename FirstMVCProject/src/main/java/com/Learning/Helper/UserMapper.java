package com.Learning.Helper;

import com.Learning.dto.userdto;
import com.Learning.entities.User;

public class UserMapper {
	
	//userDto to user 
	
	public static User convert(userdto userdto) {
		User userExesting = new User();
		userExesting.setId(userdto.getId());
		userExesting.setName(userdto.getName());
		
		userExesting.setEmail(userdto.getEmail());
		userExesting.setAadhar(userdto.getAadhar());
		userExesting.setAddress(userdto.getAddress());
		
		userExesting.setPan(userdto.getPan());
		userExesting.setPassword(userdto.getPassword());
		
		return userExesting;
	}
	public static userdto convertUserDto(User user) {
		userdto dto = new userdto();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setAadhar(user.getAadhar());
		dto.setAddress(user.getAddress());
		dto.setPan(user.getPan());
		dto.setPassword(user.getPassword());
		return dto;
	}
	
}
