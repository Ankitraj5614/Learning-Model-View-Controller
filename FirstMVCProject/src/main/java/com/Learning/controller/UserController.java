package com.Learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Learning.Dto.UserDto;
import com.Learning.entities.User;
import com.Learning.repo.userRepo;
import com.Learning.serviceimpl.userServiceImpl;

@Controller
public class UserController {


	@Autowired
	userServiceImpl service;
	
	@GetMapping("/")
	public String showhomepage() {
		return "home";
	}
	
//	@GetMapping("/register")
//	public String showRegister(Model model) {
//		
//		model.addAttribute("user", new UserDto());
//		return "register";
//	}
//	
	
	public String getAllData(Model model, @RequestParam Long id) {}
	@PostMapping("/save")
	public String  saveData(@ModelAttribute UserDto userdto) {
		service.saveUser(userdto);
		
		return "redirect:/Alluser";
	}
	@GetMapping("/Alluser")
	public String showData(Model model) {
		List<UserDto> alluser = service.getAlluser();
		model.addAttribute("userlist", alluser);
		return "viewAll";
	}
	
//	@GetMapping("/editUser")
//	public String editing (@RequestParam Long id) {
//		System.out.println("the method is changed " +id);
//		return "edit";
//	}
	//to show edit page
	@GetMapping("/editUser/{id}")
	public String editing (@PathVariable Long id,Model model) {

		model.addAttribute("user", service.getUser(id));
		
		return "edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/Alluser";
	}
	@PostMapping("/update")
	public String  updateData(@ModelAttribute UserDto userdto) {
		//to save Existing user in database
		
	
		
			service.updateUser(userdto);
	
		
		
		return "redirect:/Alluser";
	}
}
