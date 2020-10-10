package com.pro.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PET_USER")
public class PetUser implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int ID;
	private String USER_NAME;
	private String USER_PASSWD;
	private String email;
	private String Phone;
	private String type;
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_PASSWD() {
		return USER_PASSWD;
	}

	public void setUSER_PASSWD(String uSER_PASSWD) {
		USER_PASSWD = uSER_PASSWD;
	}



	public PetUser(String uSER_NAME, String uSER_PASSWD, String email, String phone, String type) {
		super();
		USER_NAME = uSER_NAME;
		USER_PASSWD = uSER_PASSWD;
		this.email = email;
		Phone = phone;
		this.type = type;
	}

	public PetUser(String uSER_NAME, String uSER_PASSWD) {
		super();

		USER_NAME = uSER_NAME;
		USER_PASSWD = uSER_PASSWD;
	}

	public PetUser(String uSER_NAME, String uSER_PASSWD, String email, String phone) {
		super();
		USER_NAME = uSER_NAME;
		USER_PASSWD = uSER_PASSWD;
		this.email = email;
		this.Phone = phone;
	}

	public PetUser() {
		// TODO Auto-generated constructor stub
	}

}
