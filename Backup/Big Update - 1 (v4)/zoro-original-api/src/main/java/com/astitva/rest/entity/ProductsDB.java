package com.astitva.rest.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="all_products")
public class ProductsDB {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productid")
	private int pid=0;
	
	@Column(name="title")
	private String title;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="location")
	private String location;
	
		
	@Column(name="imgCode")
	private String img;
	
	@Column(name="categ")
	private String categ = "electronics";
	
	@Column(name="price")
	private String price;
	
	@Column(name="owner")
	private String email;
	
	@Column(name="description")
	private String description;
	
	@Column(name="avf")
	private String avf;
	
	@Column(name="avu")
	private String avu;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		
	
	
	public ProductsDB(int pid, String title, String rating, String location, String img, String categ, String price,
			String email, String description, String avf, String avu) {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public ProductsDB() {
		//default constructor
	}
	
	

}
