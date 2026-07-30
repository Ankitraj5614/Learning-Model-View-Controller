package com.Learning.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDto {
	private Long id;
	@NotBlank(message="Enter The Name")
	private String name;
	@NotBlank(message="Enter The Email")
	private String email;
	@NotBlank(message="Enter The Address")
	private String address;
	@NotBlank(message="Enter The Valid password")
	@Pattern(  regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
		    message = "Password must contain uppercase, lowercase, number, special character and be at least 8 characters"
			)
	private String password;
	@NotBlank(message="Enter The aadhar Number")
	private String aadhar;
	@NotBlank(message="Enter The pan Number")
	private String pan;
	private String imageName;
	private String pdfName;
	
	
	public UserDto(Long id, String name, String email, String address, String password, String aadhar, String pan) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
		this.aadhar = aadhar;
		this.pan = pan;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getPdfName() {
		return pdfName;
	}
	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}
	
}
