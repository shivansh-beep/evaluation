package com.pro.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.pro.DAO.UserDAO;
import com.pro.DAO.UserDaoImp;
import com.pro.entity.Pet;
import com.pro.entity.PetCart;
import com.pro.entity.PetUser;

public class UserServiceImp implements UserService {
	UserDAO ud = new UserDaoImp();

	public boolean createUser(PetUser pu) {

		return ud.createUser(pu);
	}

	public boolean signIn(PetUser pu,HttpServletRequest req) {

		return ud.signIn(pu,req);
	}

	public ArrayList<Pet> getPetDTO() {

		return ud.getPetDTO();
	}

	public ArrayList<Pet> getMyPetDTO(String id) {
		// TODO Auto-generated method stub
		return ud.getMyPetDTO(id);
	}

	public boolean addPet(Pet pet) {
		// TODO Auto-generated method stub
		return ud.addPet(pet);
	}

	public boolean buy(String id) {
		// TODO Auto-generated method stub
		return ud.buy(id);
	}

	public ArrayList<Pet> searchtMyPetDTO(String searchInput, String doBy) {
		// TODO Auto-generated method stub
		return ud.searchtMyPetDTO(searchInput,doBy);
	}

	public ArrayList<Pet> getPetById(String id,String id2) {
		// TODO Auto-generated method stub
		return ud.getPetById(id,id2);
	}
	
	public boolean addToBasket(String petId, String loginId) {
		// TODO Auto-generated method stub
		return ud.addToBasket(petId,loginId);
	}
	public ArrayList<PetCart> getMyPetCart(String loginId, String userName) {
		// TODO Auto-generated method stub
		return ud.getMyPetCart(loginId,userName);
	}

}
