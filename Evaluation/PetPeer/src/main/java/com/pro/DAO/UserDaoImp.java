package com.pro.DAO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pro.connection.SessionCon;
import com.pro.entity.Pet;
import com.pro.entity.PetCart;
import com.pro.entity.PetUser;

public class UserDaoImp implements UserDAO {

	Session ss = new SessionCon().getConnection();

	public boolean createUser(PetUser pu) {

		ss.save(pu);

		try {
			ss.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean signIn(PetUser pu, HttpServletRequest req) {
		// TODO Auto-generated method stub
		Criteria cr = ss.createCriteria(PetUser.class);
		cr.add(Restrictions.eq("USER_NAME", pu.getUSER_NAME()));
		cr.add(Restrictions.eq("USER_PASSWD", pu.getUSER_PASSWD()));
		PetUser pu1 = (PetUser) cr.uniqueResult();

		if (pu1 != null) {
			int id = pu1.getID();
			
			HttpSession httpSession = req.getSession(false);
			httpSession.setAttribute("loginID", Integer.toString(id));
			httpSession.setAttribute("userName", pu1.getUSER_NAME());
			httpSession.setAttribute("type", pu1.getType());
			httpSession.setAttribute("ownerEmail", pu1.getEmail());
			httpSession.setAttribute("ownerPhone", pu1.getPhone());
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Pet> getPetDTO() {
		Criteria cr = ss.createCriteria(Pet.class);
		cr.add(Restrictions.eq("status", "available"));
		ArrayList<Pet> al = (ArrayList<Pet>) cr.list();
		return al;
	}

	public ArrayList<Pet> getMyPetDTO(String id) {
		int pId = Integer.valueOf(id);
		Criteria cr = ss.createCriteria(Pet.class);
		cr.add(Restrictions.eq("PET_OWNERID", pId));
		ArrayList<Pet> al = (ArrayList<Pet>) cr.list();
		return al;
	}

	public boolean addPet(Pet pet) {

		ss.save(pet);

		try {
			ss.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean buy(String id) {
		Pet pet = (Pet) ss.load(Pet.class, Integer.parseInt(id));
		pet.setStatus("unavailable");
		ss.saveOrUpdate(pet);

		try {
			ss.beginTransaction().commit();
			System.out.println("updated");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<Pet> searchtMyPetDTO(String searchInput, String doBy) {
		Criteria cr = ss.createCriteria(Pet.class);

		if (doBy.equals("breed")) {
			cr.add(Restrictions.eq("breed", searchInput));
			ArrayList<Pet> al = (ArrayList<Pet>) cr.list();
			return al;
		} else if (doBy.equalsIgnoreCase("age")) {
			cr.add(Restrictions.eq("PET_AGE", searchInput));
			ArrayList<Pet> al = (ArrayList<Pet>) cr.list();

			return al;
		} else if (doBy.equalsIgnoreCase("place")) {
			cr.add(Restrictions.eq("PET_PLACE", searchInput));
			ArrayList<Pet> al = (ArrayList<Pet>) cr.list();
			return al;
		} else if (doBy.equalsIgnoreCase("price")) {
			Query qr = ss
					.createQuery("from Pet p where p.price >= " + Integer.parseInt(searchInput) + " order by p.price");
			ArrayList<Pet> al = (ArrayList<Pet>) qr.list();
			if (al == null) {
				System.out.println("null");
			}
			return al;
		}
		return null;

	}

	public ArrayList<Pet> getPetById(String id, String id2) {
		int petId = Integer.parseInt(id);
		int ownerId = Integer.parseInt(id2);

		Criteria cr = ss.createCriteria(Pet.class);
		cr.add(Restrictions.eq("ID", petId));
		ArrayList<Pet> al = (ArrayList<Pet>) cr.list();

		return al;
	}


	
	public boolean addToBasket(String petId, String loginId) {
		
		Pet pet=(Pet) ss.load(Pet.class,Integer.parseInt(petId));
		PetUser petUser=(PetUser) ss.load(PetUser.class,Integer.parseInt(loginId));
		String uniquecode=petId+"-"+loginId;
		
		Criteria cr=ss.createCriteria(PetCart.class);
		cr.add(Restrictions.eq("uniquecode", uniquecode));
		ArrayList<PetCart> al=(ArrayList<PetCart>) cr.list();

		if(al.isEmpty()) {
		
		PetCart petCart=new PetCart(petUser.getID(), petUser.getUSER_NAME(), pet.getID(),
				pet.getPET_NAME(), pet.getPET_AGE(), pet.getPET_PLACE(), pet.getBreed(),
				pet.getPrice(), pet.getPET_OWNERID(), pet.getStatus(),uniquecode);
		
		ss.saveOrUpdate(petCart);
		try {
			ss.beginTransaction().commit();
			return true;
		}catch (Exception e) {
			return false;
		}
		}
		return false;
	}
	
	
public ArrayList<PetCart> getMyPetCart(String loginId, String userName) {
		// TODO Auto-generated method stub
	   Criteria cr=ss.createCriteria(PetCart.class);
	   cr.add(Restrictions.eq("userID",Integer.parseInt(loginId)));
	   cr.add(Restrictions.eq("userName",userName));
		return (ArrayList<PetCart>) cr.list();
	}
}
