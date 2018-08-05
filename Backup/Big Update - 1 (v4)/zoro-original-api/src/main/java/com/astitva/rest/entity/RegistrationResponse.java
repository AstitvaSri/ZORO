package com.astitva.rest.entity;

public class RegistrationResponse {
	private String email;
	private boolean register;
	private String msg;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isRegister() {
		return register;
	}
	public void setRegister(boolean register) {
		this.register = register;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public RegistrationResponse(String email, boolean register, String msg) {
		this.email = email;
		this.register = register;
		this.msg = msg;
	}
	public RegistrationResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
}
