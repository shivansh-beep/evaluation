package com.shivansh.product.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shivansh.product.model.Admin_info;
import com.shivansh.product.model.Order_Info;
import com.shivansh.product.model.Products_Info;
import com.shivansh.product.service.MyService;

@Component
@RequestMapping("/")
public class ProductController {
	@Autowired
	MyService ms;
	HttpSession hts;


	@RequestMapping("Register")
	public String reg(){
		return "Register";
	}
	@RequestMapping(value = "/registrationData", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Admin_info dto) {
		boolean b = ms.register(dto);
		if (b) {
			return new ModelAndView("Login2", "msg", "signup Successfull ");
		} else {
			return new ModelAndView("Register", "msg", " email already exists..");
		}
	}
	@RequestMapping("/Login2")
	public String login() {
		return "Login2";
	}

	@RequestMapping(value = "/loginData", method = RequestMethod.POST)
	public ModelAndView userLogIn(HttpServletRequest req) {
		String email = req.getParameter("email");
		boolean b = ms.loginData(req);
		if (b) {
			hts = req.getSession(false);
			hts.setAttribute("email", email);
			String name = (String) hts.getAttribute("name");
			return new ModelAndView("home", "msg", "logged in using :-" +name);
		} else {
			return new ModelAndView("Login2", "msg", "login failed try again please... ");
		}
	}
	@RequestMapping("Search")
	public ModelAndView search(HttpServletRequest req){
		hts=req.getSession(false);
		String email=(String) hts.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Search","msg","Serch here..");
	}else{
		return new ModelAndView("Login2","msg","Login First");

	}
	}
	
	@RequestMapping(value = "/searchOption", method = RequestMethod.POST)
	public ModelAndView searchOption(HttpServletRequest req) {
	 List<Products_Info> plist=ms.searchOption(req);
		if (plist.isEmpty()) {
			return new ModelAndView("home", "msg", " no result found");
		} else {
			return new ModelAndView("Result", "plist", plist);
		}
	}
	@RequestMapping("Add")
	public ModelAndView Add(HttpServletRequest req){
		hts=req.getSession(false);
		String email=(String) hts.getAttribute("email");
		if(email!=null){
		return new ModelAndView("Add","msg","Add New Products..");	
	}else{
		return new ModelAndView("Login2","msg","Login First");

	}
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Products_Info dto) {
		boolean b = ms.addProduct(dto);
		if (b) {
			return new ModelAndView("Add", "msg", "Saved Successfull... ");
		} else {
			return new ModelAndView("Add", "msg", " Try Again...");
		}
	}
	@RequestMapping("modifyProduct")
	public ModelAndView modifyProduct(HttpServletRequest req){
		hts=req.getSession(false);
		String email=(String) hts.getAttribute("email");
		if(email!=null){
		return new ModelAndView("modifyProduct","msg","MOdify the data of Products..");	
	}else{
		return new ModelAndView("Login2","msg","Login First");

	}
	}
	
	@RequestMapping("View")
	public ModelAndView viewAll(HttpServletRequest req){
		 List<Products_Info> plist=ms.viewAll();
		 hts=req.getSession(false);
			String email=(String) hts.getAttribute("email");
			if(email!=null){return new ModelAndView("Result", "plist", plist);
			}else{
				return new ModelAndView("Login2","msg","Login First");	
				}
		
	  }
	@RequestMapping(value="/order", method = RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest req){
		String id=req.getParameter("pid");
		String quantity=req.getParameter("qty");
		int pid=Integer.parseInt(id);
		int qty=Integer.parseInt(quantity);
		System.out.println(pid);
		System.out.println(qty);
		List<Products_Info>plist=ms.ORDER(pid,qty);
		return new ModelAndView("home", "msg", "Added To Cart");
	}
	@RequestMapping("/viewCart")
	public ModelAndView viewCart(HttpServletRequest req){
		
		List<Order_Info> olist=ms.viewCart();
		hts=req.getSession(false);
		String email=(String) hts.getAttribute("email");
		if(email!=null){
		return new ModelAndView("viewCart","olist",olist);
	}else{
		return new ModelAndView("Login2","msg","Login First");

	}
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req){
		hts=req.getSession(false);
		hts.invalidate();
		return new ModelAndView("Login2","msg","logout successful...");
	}
}
