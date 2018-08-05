package com.astitva.rest.entity;

public class VerificationResponse {
	private String email;
	private boolean otpVerified;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isOtpVerified() {
		return otpVerified;
	}
	public void setOtpVerified(boolean otpVerified) {
		this.otpVerified = otpVerified;
	}
	public VerificationResponse(String email, boolean otpVerified) {
		this.email = email;
		this.otpVerified = otpVerified;
	}
	public VerificationResponse() {
		// TODO Auto-generated constructor stub
	}
}
