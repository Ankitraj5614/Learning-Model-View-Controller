package com.Learning.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Learning.model.Employee;

@Controller
public class empController {
	
	@GetMapping("/")
	public String homePage(Model model) {
//		model.addAttribute("msg", "hi i am don ");
//		
//		Employee e = new Employee();
//		e.setEmail("raid@gmail.com");
//		e.setMob("344293");
//		e.setName("Rohit");
//		e.setRole("321");
		List<Employee> employees = Arrays.asList(
			    new Employee("Ankit Raj", "ankit.raj@gmail.com", "Software Engineer", "9876543210"),
			    new Employee("Rohit", "priya.sharma@gmail.com", "HR Manager", "9876543211"),
			    new Employee("Rahul Verma", "rahul.verma@gmail.com", "Backend Developer", "9876543212"),
			    new Employee("Sneha Gupta", "sneha.gupta@gmail.com", "Frontend Developer", "9876543213"),
			    new Employee("Amit Kumar", "amit.kumar@gmail.com", "QA Engineer", "9876543214")
			);
		model.addAttribute("employees", employees);
		model.addAttribute("emp",  new Employee("Rohit", "rohit.kumar@gmail.com", "admin", "987654877"));
		return "home";
	}
	@GetMapping("/register1")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/about")
	public String aboutUs() {
		return "about";
	}
	@GetMapping("/contact")
	public String contactUs() {
		return "contact";
	}
	@GetMapping("/prod")
	public String product() {
		return "prod";
	}
}
