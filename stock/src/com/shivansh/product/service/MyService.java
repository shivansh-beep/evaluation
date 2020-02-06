package com.shivansh.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shivansh.product.model.Admin_info;
import com.shivansh.product.model.Order_Info;
import com.shivansh.product.model.Products_Info;

public interface MyService {

public boolean register(Admin_info dto);

public boolean loginData(HttpServletRequest req);

public List<Products_Info> searchOption(HttpServletRequest req);

public boolean addProduct(Products_Info dto);

public List<Products_Info> viewAll();

public List<Products_Info> ORDER(int pid, int qty);

public List<Order_Info> viewCart();

}
