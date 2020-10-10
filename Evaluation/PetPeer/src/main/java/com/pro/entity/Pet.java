package com.pro.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PETS")
public class Pet implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int ID;
	private String PET_NAME;
	private String PET_AGE;
	private String PET_PLACE;
	private String breed;
	private int price;
	private int PET_OWNERID;
	private String status;
	private byte[] image;
	private String ownerEmail;
	private String ownerPhone;
	
	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getStatus() {
		return status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public int getPET_OWNERID() {
		return PET_OWNERID;
	}

	public void setPET_OWNERID(int pET_OWNERID) {
		PET_OWNERID = pET_OWNERID;
	}



	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerName(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public Pet() {
		// TODO Auto-generated constructor stub
	}



	public Pet(String pET_NAME, String pET_AGE, String pET_PLACE, String breed, int price, int pET_OWNERID,
			String status, byte[] image, String ownerEmail, String ownerPhone) {
		super();
		PET_NAME = pET_NAME;
		PET_AGE = pET_AGE;
		PET_PLACE = pET_PLACE;
		this.breed = breed;
		this.price = price;
		PET_OWNERID = pET_OWNERID;
		this.status = status;
		this.image = image;
		this.ownerEmail = ownerEmail;
		this.ownerPhone = ownerPhone;
	}
	
	

}
