package com.astitva.rest.entity;

public class LoginUser {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public LoginUser() {
		// TODO Auto-generated constructor stub
	}
	public LoginUser(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
