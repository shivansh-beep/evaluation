package com.shivansh.product.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Products_Info {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
private int pid;
	
private String name; 
private String category ;
private String company;
private int quantity;
private double price ;


@OneToMany(cascade=CascadeType.ALL)
@JoinTable(name="Order_History_Info",joinColumns=@JoinColumn(name="pid"),inverseJoinColumns=@JoinColumn(name="oid"))
private List<Order_Info> olist;



public List<Order_Info> getOlist() {
	return olist;
}

public void setOlist(List<Order_Info> olist) {
	this.olist = olist;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

}
