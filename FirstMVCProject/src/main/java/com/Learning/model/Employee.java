package com.Learning.model;

public class Employee {
	
	private String name;
	private String email;
	private String role;
	private String mob;
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", role=" + role + ", mob=" + mob + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String email, String role, String mob) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
		this.mob = mob;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	
}
