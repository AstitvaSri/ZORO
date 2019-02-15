package com.astitva.rest.entity;

public class Existence {
	private String email;
	private boolean found;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.trim();
	}
	
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	public Existence(String email, boolean found) {
		this.email = email.trim();
		this.found = found;
	}
	public Existence() {
	}	

}
