package com.astitva.rest.entity;


public class DetailsJson {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String aadharID;
	private String city;
	private String state;
	
	
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAadharID() {
		return aadharID;
	}
	public void setAadharID(String aadharID) {
		this.aadharID = aadharID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public DetailsJson(String email,String password,String firstName, String lastName, String gender, int age, String aadharID, String city,
			String state) {
		this.email=email.trim();
		this.password=password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.aadharID = aadharID;
		this.city = city;
		this.state = state;
	}
	public DetailsJson() {
		// TODO Auto-generated constructor stub
	}
}
