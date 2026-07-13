package com.Learning.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learning.entities.User;
import com.Learning.repo.userRepo;
import com.Learning.service.UserService;

@Service
public class userServiceImpl implements UserService {
	@Autowired
	userRepo repo;
	@Override
	public User saveUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public List<User> getAlluser() {
		List<User> list = repo.findAll();
		return list;
	}
	
	@Override
	public User getUser(Long id) {
		Optional<User> op= repo.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

}
