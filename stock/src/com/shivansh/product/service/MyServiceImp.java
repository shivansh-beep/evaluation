package com.shivansh.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shivansh.product.dao.MyDAO;
import com.shivansh.product.model.Admin_info;
import com.shivansh.product.model.Order_Info;
import com.shivansh.product.model.Products_Info;

@Component
public class MyServiceImp implements MyService {
	@Autowired
	MyDAO md;
	
	@Override
	public boolean register(Admin_info dto) {

		return md.register(dto);
	}

	@Override
	public boolean loginData(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return  md.loginData(req);
	}

	public List<Products_Info> searchOption(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.searchOption(req);
	}

	@Override
	public boolean addProduct(Products_Info dto) {
		// TODO Auto-generated method stub
		return md.addProduct(dto);

	}

	@Override
	public List<Products_Info> viewAll() {
		// TODO Auto-generated method stub
		return md.viewAll();
	}

	@Override
	public List<Products_Info> ORDER(int pid, int qty) {
		// TODO Auto-generated method stub
		return md.ORDER(pid,qty);
	}

	@Override
	public List<Order_Info> viewCart() {
		// TODO Auto-generated method stub
		return md.viewCart();
	}

}
