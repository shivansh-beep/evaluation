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
public class Order_Info {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	
private int	oid ;
	private double total_price; 
	private double total_price_with_gst ;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Order_History_Info",joinColumns=@JoinColumn(name="oid"),inverseJoinColumns=@JoinColumn(name="pid"))
	private List<Products_Info> plist;

	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public double getTotal_price_with_gst() {
		return total_price_with_gst;
	}
	public void setTotal_price_with_gst(double total_price_with_gst) {
		this.total_price_with_gst = total_price_with_gst;
	}
	public List<Products_Info> getPlist() {
		return plist;
	}
	public void setPlist(List<Products_Info> plist) {
		this.plist = plist;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}

	
	
	
}
