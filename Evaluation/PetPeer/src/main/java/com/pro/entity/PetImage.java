package com.pro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class PetImage {
	
	@Id
//	@GenericGenerator(name = "auto", strategy = "increment")
//	@GeneratedValue(generator = "auto")
	int id;
	
	String petid;
	
	 private byte[] image;

	public String getPetid() {
		return petid;
	}

	public void setPetid(String petid) {
		this.petid = petid;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PetImage(String petid, byte[] image) {
		super();
		this.petid = petid;
		this.image = image;
	}
	 
	 public PetImage() {
		// TODO Auto-generated constructor stub
	}

}
