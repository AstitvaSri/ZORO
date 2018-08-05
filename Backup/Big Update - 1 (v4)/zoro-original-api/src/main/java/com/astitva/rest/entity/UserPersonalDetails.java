package com.astitva.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_personal_details")
public class UserPersonalDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pswd")
	private String password;
	
	@Column(name="details_json")
	private String detailsJson;	
	
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.trim();
	}
	public String getDetailsJson() {
		return detailsJson;
	}
	public void setDetailsJson(String detailsJson) {
		this.detailsJson = detailsJson;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public UserPersonalDetails(String email, String password, String detailsJson) {
		this.email = email.trim();
		this.password = password;
		this.detailsJson = detailsJson;
	}
	public UserPersonalDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "UserPersonalDetails [id=" + id + ", email=" + email + ", detailsJson=" + detailsJson + "]";
	}
	
	
	

}
