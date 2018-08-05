package com.astitva.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="otp_entries")
public class UnverifiedEntries {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="unverified_emails")
	private String unverifiedEmail;
	
	@Column(name="current_otp")
	private String currentOtp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnverifiedEmail() {
		return unverifiedEmail;
	}

	public void setUnverifiedEmail(String unverifiedEmail) {
		this.unverifiedEmail = unverifiedEmail.trim();
	}

	public String getCurrentOtp() {
		return currentOtp;
	}

	public void setCurrentOtp(String currentOtp) {
		this.currentOtp = currentOtp;
	}

	public UnverifiedEntries(String unverifiedEmail, String currentOtp) {
		this.unverifiedEmail = unverifiedEmail.trim();
		this.currentOtp = currentOtp;
	}

	public UnverifiedEntries() {
	}
	
	

}
