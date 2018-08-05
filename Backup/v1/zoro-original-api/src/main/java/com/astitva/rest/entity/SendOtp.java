package com.astitva.rest.entity;

public class SendOtp {
	private String email;
	private String otp;
	private boolean found;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	public SendOtp(String email, String otp, boolean found) {
		this.email = email;
		this.otp = otp;
		this.found = found;
	}
	public SendOtp() {
	}
	

}
