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
	
	@Column(name="avail")
	private String avail;
	
	@Column(name="imgPath")
	private String img;
	
	@Column(name="categ")
	private String categ = "electronics";
	
	@Column(name="price")
	private String price;
	
	@Column(name="owner")
	private String email;
	
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
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
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
	
	
	public ProductsDB(int pid,String title, String rating, String location, String avail, String img, String categ, String price, String email) {
		super();
		this.pid = pid;
		this.title = title;
		this.rating = rating;
		this.location = location;
		this.avail = avail;
		this.img = img;
		this.categ = categ;
		this.price = price;
		this.email = email;
	}
	
	public ProductsDB() {
		//default constructor
	}
	@Override
	public String toString() {
		return "ProductsDB [pid=" + pid + ", title=" + title + ", rating=" + rating + ", location=" + location
				+ ", avail=" + avail + ", img=" + img + ", categ=" + categ + ", price=" + price + ", email=" + email
				+ "]";
	}
	
	

}
