package com.shivansh.product.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shivansh.product.model.Admin_info;
import com.shivansh.product.model.Order_Info;
import com.shivansh.product.model.Products_Info;

@Component
public class MyDaoImp implements MyDAO {
	@Autowired
	SessionFactory sf;
	HttpSession hts;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	@Override
	public boolean register(Admin_info dto) {
		Session ss = sf.openSession();
		String email=dto.getEmail();
		Criteria cr=ss.createCriteria(Admin_info.class);
		cr.add(Restrictions.eq("email", email));
		Admin_info ai=(Admin_info) cr.uniqueResult();
		if(ai==null){
		ss.save(dto);
		ss.beginTransaction().commit();
		ss.close();
		return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean loginData(HttpServletRequest req) {
		Session ss = sf.openSession();
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Criteria cr=ss.createCriteria(Admin_info.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", password));
		Admin_info ai=(Admin_info) cr.uniqueResult();
	if(ai!=null){
	String name=ai.getName();
	hts=req.getSession(false);
	hts.setAttribute("name", name);
	ss.close();
		return true;
	}else{
		ss.close();
		return false;
	}
	}

	@Override
	public List<Products_Info> searchOption(HttpServletRequest req) {
		
		Session ss = sf.openSession();
		String option=req.getParameter("searchBy");
		String product=req.getParameter("product");
		System.out.println(option);
		Criteria cr=ss.createCriteria(Products_Info.class);
		cr.add(Restrictions.ilike(option, product, MatchMode.ANYWHERE));
		
List<Products_Info> plist=cr.list();

ss.close();


	return plist;
	}

	@Override
	public boolean addProduct(Products_Info dto) {
		if(dto!=null){
		Session ss = sf.openSession();
		ss.saveOrUpdate(dto);
		ss.beginTransaction().commit();
		return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Products_Info> viewAll() {
		Session ss = sf.openSession();
		Criteria cr=ss.createCriteria(Products_Info.class);
List<Products_Info> plist=cr.list();
ss.close();// TODO Auto-generated method stub
		return plist;
	}

	@Override
	public List<Products_Info> ORDER(int pid, int qty)  {
		Session ss = sf.openSession();
		

		
	Products_Info pdto=ss.load(Products_Info.class, pid);
	
	int newQty=pdto.getQuantity()-qty;
	pdto.setQuantity(newQty);
	ss.saveOrUpdate(pdto);
	ss.beginTransaction().commit();
	
	//orderinfo
	
	double price=pdto.getPrice();
	double totalPrice=qty*price;
	double priceWGst=(totalPrice*1.18);
	
	
	Order_Info odto=new Order_Info();
	
	odto.setTotal_price(totalPrice);
	
	odto.setTotal_price_with_gst(priceWGst);
	
	List<Products_Info> pinfo=new ArrayList<Products_Info>();
	pinfo.add(pdto);
	odto.setPlist(pinfo);
	ss.saveOrUpdate(odto);
	try{
	ss.beginTransaction().commit();
	}catch(Exception e){
		Criteria  cr=ss.createCriteria(Products_Info.class);
		List<Products_Info> plist1=cr.list();
ss.close();
			return plist1;
	}
	Criteria  cr=ss.createCriteria(Products_Info.class);
	List<Products_Info> plist1=cr.list();
ss.close();
		return plist1;
	}

	@Override
	public List<Order_Info> viewCart() {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(Order_Info.class);
		List<Order_Info> olist=cr.list();
		return olist;
	}

}
