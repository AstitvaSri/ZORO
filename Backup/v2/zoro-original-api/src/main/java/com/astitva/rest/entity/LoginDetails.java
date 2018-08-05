package com.astitva.rest.entity;

public class LoginDetails {
	private String email;
	private String name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LoginDetails(String email, String name) {
		this.email = email;
		this.name = name;
	}
	public LoginDetails() {
	}
	
	
	
}
