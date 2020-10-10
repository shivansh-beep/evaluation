package com.pro.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.pro.entity.Pet;
import com.pro.entity.PetCart;
import com.pro.entity.PetUser;

public interface UserService {
	public boolean createUser(PetUser pu);

	public boolean signIn(PetUser pu, HttpServletRequest req);

	public ArrayList<Pet> getPetDTO();

	public ArrayList<Pet> getMyPetDTO(String id);

	public boolean addPet(Pet pet);

	public boolean buy(String id);

	public ArrayList<Pet> searchtMyPetDTO(String searchInput, String doBy);

	public ArrayList<Pet> getPetById(String id, String id2);

	public boolean addToBasket(String petId, String loginId);

	public ArrayList<PetCart> getMyPetCart(String loginId, String userName);
}
