package com.pro.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pro.connection.SessionCon;
import com.pro.entity.Pet;
import com.pro.entity.PetCart;
import com.pro.entity.PetImage;
import com.pro.entity.PetUser;
import com.pro.services.UserService;
import com.pro.services.UserServiceImp;

@Controller
public class MyController {

	UserService us = new UserServiceImp();
	String id;
	String userName;

	@RequestMapping(value = "/userregn")
	public String userRegn() {
		return "userregn";
	}
	@RequestMapping(value = "/getImage")
	public String getImage() {
		return "getImage";
	}

	@RequestMapping(value = "/SearchByBreed")
	public String searchByBreed() {
		return "SearchByBreed";
	}

	@RequestMapping(value = "/Login")
	public String logIn() {
		return "Login";
	}

	@RequestMapping(value = "/addPet")
	public String addPet() {
		return "AddPet";
	}

	@RequestMapping(value = "/pet_home2")
	public String pet_home2() {
		return "pet_home2";
	}

	@RequestMapping(value = "/SearchByAge")
	public String searchByAge() {
		return "SearchByAge";
	}

	@RequestMapping(value = "/SearchByPlace")
	public String searchByPlace() {
		return "SearchByPlace";
	}

	@RequestMapping(value = "/SearchByPrice")
	public String searchByPrice() {
		return "SearchByPrice";
	}

	@RequestMapping(value = "/upload")
	public String upload() {
		return "upload";
	}

	@RequestMapping(value = "/getuser")
	public String getuser() {
		return "getuser";
	}

	@RequestMapping(value = "/SellerHome")
	public String sellerHome() {
		return "SellerHome";
	}

	@RequestMapping(value = "/registered", method = RequestMethod.POST)
	public ModelAndView registered(@RequestParam("userName") String username, @RequestParam("password1") String pass,
			@RequestParam("password2") String pass2, @RequestParam("phone") String phone,
			@RequestParam("email") String email, @RequestParam("type") String type) {
		if (pass.equals(pass2)) {
			PetUser pu = new PetUser(username, pass, email, phone, type);

			boolean b = us.createUser(pu);

			if (b) {
				return new ModelAndView("registered", "msg", "Registraion Successfull please as: " + type + "<hr>");
			} else {
				return new ModelAndView("userregn", "msg", "username already exist try with another username <hr>");
			}
		} else {
			return new ModelAndView("userregn", "msg", "Password Didn't Match try again....");
		}
	}

	@RequestMapping(value = "/byBreed")
	public ModelAndView byBreed(@RequestParam("breed") String breed, @RequestParam("doBy") String doBy,
			HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			ArrayList<Pet> myPetList = us.searchtMyPetDTO(breed, doBy);
			return new ModelAndView("MyPet", "myPetList", myPetList);
		}

	}

	@RequestMapping(value = "/byAge")
	public ModelAndView byAge(@RequestParam("age") String age, @RequestParam("doBy") String doBy,
			HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			ArrayList<Pet> myPetList = us.searchtMyPetDTO(age, doBy);
			return new ModelAndView("MyPet", "myPetList", myPetList);
		}

	}

	@RequestMapping(value = "/byPlace")
	public ModelAndView byPlace(@RequestParam("place") String place, @RequestParam("doBy") String doBy,
			HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			ArrayList<Pet> myPetList = us.searchtMyPetDTO(place, doBy);
			return new ModelAndView("MyPet", "myPetList", myPetList);
		}

	}

	@RequestMapping(value = "/byPrice")
	public ModelAndView byPrice(@RequestParam("price") String price, @RequestParam("doBy") String doBy,
			HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			ArrayList<Pet> myPetList = us.searchtMyPetDTO(price, doBy);
			return new ModelAndView("MyPet", "myPetList", myPetList);
		}

	}

	@RequestMapping(value = "/signIn")
	public ModelAndView signIn(@RequestParam("userName") String username, @RequestParam("password") String pass,
			HttpServletRequest req) {

		PetUser pu = new PetUser(username, pass);
		boolean b = us.signIn(pu, req);

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		String type = (String) httpSession.getAttribute("type");

		if (type.equalsIgnoreCase("buyer")) {
			if (id != null) {
				if (b) {
					return new ModelAndView("pet_home2"/* "petList", petList */);
				} else {
					return new ModelAndView("Login", "msg", "login failed <hr>");
				}
			} else {
				return new ModelAndView("Login", "msg", "login first <hr>");
			}
		} else {
			if (b) {
				return new ModelAndView("SellerHome");
			} else {
				return new ModelAndView("Login", "msg", "login failed <hr>");
			}

		}
	}

	@RequestMapping(value = "/myPets")
	public ModelAndView myPets(HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");

		System.out.println(id);

		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			ArrayList<Pet> myPetList = us.getMyPetDTO(id);
			return new ModelAndView("MyPet", "myPetList", myPetList);
		}

	}

	@RequestMapping(value = "/myBasket")
	public ModelAndView myBasket(HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		userName = (String) httpSession.getAttribute("userName");
		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			ArrayList<PetCart> myPetBasket = us.getMyPetCart(id, userName);
			return new ModelAndView("MyBasket", "myPetBasket", myPetBasket);
		}

	}

	@RequestMapping(value = "/viewPet")
	public ModelAndView viewPet(@RequestParam("petId") String petID, HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");

		// String petID=req.getParameter("petId");

		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			ArrayList<Pet> myPetList = us.getPetById(petID, id);
			return new ModelAndView("viewPet", "myPetList", myPetList);
		}

	}

	@RequestMapping(value = "/buy")
	public ModelAndView buy(HttpServletRequest req) {
		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");

		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");
		} else {
			String petId = req.getParameter("petId");
			boolean b = us.buy(petId);
			if (b) {
				return new ModelAndView("pet_home2");
			} else {
				return new ModelAndView("pet_home2");
			}
		}
	}

	@RequestMapping(value = "/addToBasket")
	public ModelAndView addToBasket(HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");

		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");
		} else {
			String petId = req.getParameter("petId");
			boolean b = us.addToBasket(petId, id);
			if (b) {
				return new ModelAndView("pet_home2", "msg", "added to basket");
			} else {
				return new ModelAndView("pet_home2", "msg", "Pet is Already in your Basket");
			}
		}
	}

	@RequestMapping(value = "/petData", method = RequestMethod.POST)
	public ModelAndView addPet(@RequestParam("PET_NAME") String petName, @RequestParam("PET_AGE") String petAge,
			@RequestParam("PET_PLACE") String petPlace, @RequestParam("breed") String breed,
			@RequestParam("price") String price, @RequestParam("file") MultipartFile file, HttpServletRequest req)
			throws NumberFormatException, IOException {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		String ownerEmail=(String) httpSession.getAttribute("ownerEmail");
		String ownerPhone=(String) httpSession.getAttribute("ownerPhone");
		
		httpSession.setAttribute("pid", petName + petPlace);

		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			Pet pet = new Pet(petName, petAge, petPlace, breed, Integer.parseInt(price), Integer.parseInt(id),
					"available", file.getBytes(),ownerEmail,ownerPhone);

			boolean b = us.addPet(pet);
			if (b) {
				return new ModelAndView("AddPet", "msg", "pet added successfully");
			} else {
				return new ModelAndView("AddPet", "msg", "something went wrong try again");
			}
		}
	}


	@RequestMapping(value = "/Logout")
	public ModelAndView logOut(HttpServletRequest req) {

		HttpSession httpSession = req.getSession(false);
		id = (String) httpSession.getAttribute("loginID");
		if (id.isEmpty()) {
			return new ModelAndView("Login", "msg", "login first <hr>");

		} else {
			httpSession.removeAttribute("loginID");
			System.out.println(httpSession.getAttribute("loginID"));
			httpSession.invalidate();
			return new ModelAndView("index", "msg", "logged out...");
		}
	}

}
