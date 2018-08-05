package com.astitva.rest.entity;

public class ZorroTest {
	private int ID;
	private String UserName;
	private String Password;
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public ZorroTest(int ID, String UserName, String Password) {
		this.ID = ID;
		this.UserName = UserName;
		this.Password = Password;
	}
	public ZorroTest() {
	}
	
	
}
