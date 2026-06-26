package com.Learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Learning.model.Employee;

@Controller
public class empController {
	
	@GetMapping("/")
	public String homePage(Model model) {
//		model.addAttribute("msg", "hi i am don ");
		
		Employee e = new Employee();
		e.setEmail("aad@gmail.com");
		e.setMob("344293");
		e.setName("ankit");
		e.setRole("342");
		model.addAttribute("emp", e);
		return "home";
	}
}
