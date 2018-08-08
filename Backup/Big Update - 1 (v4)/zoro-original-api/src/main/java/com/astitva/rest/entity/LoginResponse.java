package com.astitva.rest.entity;

public class LoginResponse {

	private String email;
	private boolean success;
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public LoginResponse(String email, boolean success, String msg) {
		this.email = email;
		this.success = success;
		this.msg = msg;
	}
	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
}
