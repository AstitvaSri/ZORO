package com.astitva.rest.entity;

public class Product {
	private int pid;
	private String title;
	private String rating;
	private String location;
	private String img;//image code
	private String categ;
	private String price;
	private String email;
	private String avf;
	private String avu;
	private String description;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvf() {
		return avf;
	}
	public void setAvf(String avf) {
		this.avf = avf;
	}
	public String getAvu() {
		return avu;
	}
	public void setAvu(String avu) {
		this.avu = avu;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCateg() {
		return categ;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}
	public Product(int pid, String title, String rating, String location, String img, String categ, String price, String email, String description, String avf, String avu) {
		super();
		this.pid = pid;
		this.title = title;
		this.rating = rating;
		this.location = location;
		this.img = img;
		this.categ = categ;
		this.price = price;
		this.email = email;
		this.description = description;
		this.avf = avf;
		this.avu = avu;
	}
	
	public Product() {
		//default constructor
	}

}
