package com.shivansh.product.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.shivansh.product.model.Admin_info;
import com.shivansh.product.model.Order_Info;
import com.shivansh.product.model.Products_Info;

public interface MyDAO {


public boolean register(Admin_info dto);

public boolean loginData(HttpServletRequest req);

public List<Products_Info> searchOption(HttpServletRequest req);

public boolean addProduct(Products_Info dto);

public List<Products_Info> viewAll();

public List<Products_Info> ORDER(int pid, int qty) ;

public List<Order_Info> viewCart();

}
