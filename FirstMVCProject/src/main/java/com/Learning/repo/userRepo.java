package com.Learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Learning.entities.User;

public interface userRepo extends JpaRepository<User, Integer>{

}
