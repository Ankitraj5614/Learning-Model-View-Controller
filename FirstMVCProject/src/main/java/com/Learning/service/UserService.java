package com.Learning.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Learning.Dto.UserDto;

@Service
public interface UserService {
		//to save data user
	UserDto saveUser(UserDto user);
	//to view all users
	List<UserDto> getAlluser();
	
	Page<UserDto> getAllPaginationDataUser(Pageable pageable);
	
	void delete(Long id);
	UserDto getUser(Long id);
	public UserDto updateUser(UserDto userdto);
}
