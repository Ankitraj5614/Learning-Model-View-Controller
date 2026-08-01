package com.Learning.controller;



import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Learning.Dto.UserDto;

import com.Learning.serviceimpl.userServiceImpl;
import com.Learning.utils.FileUploadUtils;

import jakarta.validation.Valid;

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
		
		model.addAttribute("userdto", new UserDto());
	return "register";
	}

	//Validation in save method

	@PostMapping("/save")
	public String saveUser(@Valid @ModelAttribute("userdto") UserDto userdto, BindingResult result, Model model,
			@RequestParam("imgpart") MultipartFile imgpart, @RequestParam("pdfpart") MultipartFile pdfpart) {

		if (result.hasErrors()) {
			System.out.println("error occured!!");
			model.addAttribute("userdto", userdto);
			return "register";
		}

		// extract orginal image and pdf file name
		String imageName = null;
		String pdfName = null;

		// extract image name
		if (imgpart != null && !imgpart.isEmpty()) {
			imageName = StringUtils.cleanPath(Objects.requireNonNull(imgpart.getOriginalFilename()));
			// set imagename to userDto
			userdto.setImageName(imageName);
		}

		// extract pdf name
		if (pdfpart != null && !pdfpart.isEmpty()) {
			pdfName = StringUtils.cleanPath(Objects.requireNonNull(pdfpart.getOriginalFilename()));
			// set pdfname to userdto
			userdto.setPdfName(pdfName);
		}

		// save user to database with file names
		UserDto savedUser = service.saveUser(userdto);

		// now save file in directory/folder
		try {
			String uploadDirectory = "myfiles/" + savedUser.getId();// myfiles/2
			FileUploadUtils.saveFile(uploadDirectory, imageName, imgpart);

			FileUploadUtils.saveFile(uploadDirectory, pdfName, pdfpart);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/Alluser";
	}	
//	@GetMapping("/Alluser")
//	public String showData(Model model) {
//		List<UserDto> alluser = service.getAlluser();
//		model.addAttribute("userlist", alluser);
//		return "viewAll";
//	}
	@GetMapping("/Alluser")
	public String getAllData(Model model, @RequestParam(defaultValue="0") int pageNo ) {
		int pageSize =3;
		if(pageNo<0)
			pageNo=0;
		Pageable page= PageRequest.of(pageNo, pageSize);
		Page<UserDto> page1 = service.getAllPaginationDataUser(page);
		
		model.addAttribute("userpage", page1);
		model.addAttribute("currentpage", pageNo);
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
