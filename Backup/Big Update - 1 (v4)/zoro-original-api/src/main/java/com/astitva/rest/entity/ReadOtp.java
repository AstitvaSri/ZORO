package com.astitva.rest.entity;

public class ReadOtp {
	private String email;
	private String otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.trim();
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public ReadOtp(String email, String otp) {
		this.email = email.trim();
		this.otp = otp;
	}
	public ReadOtp() {
		// TODO Auto-generated constructor stub
	}
}
