package com.Learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Learning.entities.User;
import com.Learning.serviceimpl.userServiceImpl;

@Controller
public class UserController {
	@Autowired
	userServiceImpl service;
	
	@GetMapping("/")
	public String showhomepage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/save")
	public String  saveData(@ModelAttribute User user) {
		service.saveUser(user);
		
		return "redirect:/ViewAll";
	}
	@GetMapping("/ViewAll")
	public String showData() {
		return "ViewAll";
	}
}
