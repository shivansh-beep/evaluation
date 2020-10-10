package com.pro.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class PetCart implements Serializable {

	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator = "auto")
	private int cartID;
	
	private int userID;
	private String userName;
	
	private int petID;
	private String PET_NAME;
	private String PET_AGE ;
	private String PET_PLACE ;
	private String breed;
	private int price;
	private int PET_OWNERID ;
	private String status;
	private String uniquecode;
	
	
	
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPetID() {
		return petID;
	}
	public void setPetID(int petID) {
		this.petID = petID;
	}
	public String getPET_NAME() {
		return PET_NAME;
	}
	public void setPET_NAME(String pET_NAME) {
		PET_NAME = pET_NAME;
	}
	public String getPET_AGE() {
		return PET_AGE;
	}
	public void setPET_AGE(String pET_AGE) {
		PET_AGE = pET_AGE;
	}
	public String getPET_PLACE() {
		return PET_PLACE;
	}
	public void setPET_PLACE(String pET_PLACE) {
		PET_PLACE = pET_PLACE;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPET_OWNERID() {
		return PET_OWNERID;
	}
	public void setPET_OWNERID(int pET_OWNERID) {
		PET_OWNERID = pET_OWNERID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getUniquecode() {
		return uniquecode;
	}
	public void setUniquecode(String uniquecode) {
		this.uniquecode = uniquecode;
	}
	public PetCart() {
		// TODO Auto-generated constructor stub
	}
	public PetCart(int userID, String userName, int petID, String pET_NAME, String pET_AGE, String pET_PLACE,
			String breed, int price, int pET_OWNERID, String status,String uniquecode) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.petID = petID;
		PET_NAME = pET_NAME;
		PET_AGE = pET_AGE;
		PET_PLACE = pET_PLACE;
		this.breed = breed;
		this.price = price;
		PET_OWNERID = pET_OWNERID;
		this.status = status;
		this.uniquecode = uniquecode;
	}
	
	
}
