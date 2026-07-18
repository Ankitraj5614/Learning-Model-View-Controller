package com.Learning.serviceimpl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Learning.Dto.UserDto;


import com.Learning.entities.User;
import com.Learning.repo.userRepo;
import com.Learning.service.UserService;

@Service
public class userServiceImpl implements UserService {
	@Autowired
	private userRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public UserDto saveUser(UserDto userDto) {
		
			User user =mapper.map(userDto, User.class);
		
		User saveUser =repo.save(user);
		
		UserDto dto=mapper.map(saveUser, UserDto.class);
		
		return dto;
	}

	@Override
	public List<UserDto> getAlluser() {
		
		List<User> list = repo.findAll();
		//Two Way
		

		List<UserDto> UDtoList = list.stream()
		        .map(entity -> mapper.map(entity, UserDto.class))
		        .collect(Collectors.toList());
		//One Way
//		List<UserDto> UDtoList = new ArrayList<>();
//		for(User user:list)
//		UDtoList.add(UserMapper.convertUserDto(user));
		return UDtoList;
	}
	
	@Override
	public UserDto getUser(Long id) {
		
		Optional<User> op= repo.findById(id);
		
		if (op.isPresent()) {
			UserDto dto=mapper.map(op.get(), UserDto.class);
			return dto;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

	public UserDto updateUser(UserDto userdto) {
		
	User existingUser=repo.findById(userdto.getId()).orElse(null);
	
		existingUser.setAadhar(userdto.getAadhar());
		existingUser.setName(userdto.getName());
		existingUser.setAddress(userdto.getAddress());
		existingUser.setPan(userdto.getPan());
		User saveEntity=repo.save(existingUser);
	
		return mapper.map(saveEntity, UserDto.class);
	}

	@Override
	public Page<UserDto> getAllPaginationDataUser(Pageable pageable) {
		Page<User> page=repo.findAll(pageable);
		Page<UserDto> page1=page.map(u -> mapper.map(u, UserDto.class));
		return page1;
	}
	

}
