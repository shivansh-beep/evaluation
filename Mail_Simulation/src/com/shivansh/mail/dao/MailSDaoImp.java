package com.shivansh.mail.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shivansh.mail.model.MailInfoDTO;
import com.shivansh.mail.model.UserDTO;

@Component
public class MailSDaoImp implements MailDao {
	@Autowired
	SessionFactory sf;
	HttpSession hss;

	@Override
	public boolean register(UserDTO dto) {
		// TODO Auto-generated method stub
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", dto.getEmail()));
		String eml = dto.getEmail();
		UserDTO udto = (UserDTO) cr.uniqueResult();
		if (udto == null) {
			ss.save(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			ss.close();
			return false;
		}
	}

	@Override
	public boolean loginData(HttpServletRequest req) {
		Session ss = sf.openSession();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", password));
		UserDTO rdto = (UserDTO) cr.uniqueResult();

		if (rdto != null) {
			int uid = rdto.getUid();
			String userName = rdto.getUserName();
			this.hss = req.getSession();
			hss.setAttribute("uid", uid);
			hss.setAttribute("userName", userName);
			return true;
		} else {
			this.hss = req.getSession();
			return false;
		}
	}

	@Override
	public boolean sendMail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		String toemail = req.getParameter("email");
		String inbox = req.getParameter("message");
		String subject = req.getParameter("subject");
		this.hss = req.getSession(false);

		String fromMail = (String) this.hss.getAttribute("email");
		Session ss = sf.openSession();

		MailInfoDTO mdto = null;
		
		Query qry = ss.createQuery("from UserDTO where email='" + toemail + "'");
		UserDTO rdto = (UserDTO) qry.uniqueResult();
		List<MailInfoDTO> mlist;

		if (rdto != null) {
			mdto = new MailInfoDTO();
			mdto.setFromId(fromMail);
			mdto.setMessage(inbox);
			mdto.setToId(toemail);
			mdto.setSubject(subject);
			mdto.setStatus("sent");
			mlist = rdto.getMlist();
			mlist.add(mdto);
			ss.saveOrUpdate(rdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			mdto = new MailInfoDTO();
			mdto.setStatus("draft");
			mdto.setFromId(fromMail);
			mdto.setToId(toemail);
			mdto.setMessage(inbox);
			mdto.setSubject(subject);
			qry = ss.createQuery("from UserDTO where email='" + fromMail + "'");
			rdto = (UserDTO) qry.uniqueResult();
			mlist = rdto.getMlist();
			mlist.add(mdto);
			ss.saveOrUpdate(rdto);
			ss.beginTransaction().commit();
			ss.close();
			return false;
		}
	}

	@Override
	public List<MailInfoDTO> sent(String uid) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(MailInfoDTO.class);
		cr.add(Restrictions.eq("fromId", uid));
		String status = "sent";
		cr.add(Restrictions.eq("status", status));
		List<MailInfoDTO> mlist = cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public List<MailInfoDTO> draft(String email) {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(MailInfoDTO.class);
		cr.add(Restrictions.eq("fromId", email));
		String status = "draft";
		cr.add(Restrictions.eq("status", status));
		List<MailInfoDTO> mlist = cr.list();
		ss.close();
		return mlist;

	}

	@Override
	public List<MailInfoDTO> inbox(String fromMail) {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(MailInfoDTO.class);
		cr.add(Restrictions.eq("toId", fromMail));
		String status = "sent";
		//cr.add(Restrictions.eq("status", status));
		List<MailInfoDTO> mlist = cr.list();
		ss.close();
		return mlist;

	}

	public boolean password(UserDTO dto, HttpServletRequest req) {
		Session ss = sf.openSession();

		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", email));

		UserDTO udto = (UserDTO) cr.uniqueResult();
		String password = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		boolean b = password.equals(password2);
		if (password != null && b) {
			udto.setPassword(password);
			ss.saveOrUpdate(dto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			ss.close();
			return false;
		}

	}

	public List<UserDTO> Forgot(HttpServletRequest req) {
		Session ss = sf.openSession();
		String email = req.getParameter("email");
		Query qry = ss.createQuery("from UserDTO where email='" + email + "'");

		UserDTO rdto = (UserDTO) qry.uniqueResult();
		if (rdto != null) {

			Criteria cr = ss.createCriteria(UserDTO.class);
			cr.add(Restrictions.eq("email", email));
			UserDTO udto = (UserDTO) cr.uniqueResult();

			List<UserDTO> ulist = cr.list();
			ss.close();
			return ulist;
		} else {
			List<UserDTO> ulist = null;
			return ulist;
		}
	}

	public boolean Ans(HttpServletRequest req) {
		Session ss = sf.openSession();

		String securityAns = req.getParameter("securityAns");

		Criteria cr = ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("securityAns", securityAns));

		UserDTO udto = (UserDTO) cr.uniqueResult();

		if (udto != null) {

			String ans = udto.getSecurityAns();
			String email = udto.getEmail();

			hss = req.getSession(false);
			hss.setAttribute("email", email);

			if (securityAns.equalsIgnoreCase(ans)) {
				ss.close();
				return true;
			} else {
				ss.close();
				return false;
			}
		} else {
			ss.close();
			return false;
		}
	}

	public boolean delete(HttpServletRequest req) {
		hss = req.getSession(false);
		int id = (int) hss.getAttribute("id");
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(MailInfoDTO.class);
		cr.add(Restrictions.eq("id", id));
		MailInfoDTO mdto = (MailInfoDTO) cr.uniqueResult();
		String status = "delete";
		List<MailInfoDTO> mlist = cr.list();

		if (mdto != null) {
			mdto.setStatus(status);
			ss.saveOrUpdate(mdto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			ss.close();
			return false;
		}
	}

	public List<MailInfoDTO> deletedMessages(HttpServletRequest req) {
		Session ss = sf.openSession();
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");
		Criteria cr = ss.createCriteria(MailInfoDTO.class);
		cr.add(Restrictions.eq("fromId", email));
		String status = "delete";
		cr.add(Restrictions.eq("status", status));
		List<MailInfoDTO> mlist = cr.list();
		if (mlist != null) {
			ss.close();
			return mlist;
		} else {
			return null;
		}
	}

	public List<MailInfoDTO> PermanantDelete(HttpServletRequest req) {

		hss = req.getSession(false);
		int id = (int) hss.getAttribute("id");

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(MailInfoDTO.class);
		cr.add(Restrictions.eq("id", id));
		MailInfoDTO mdto = (MailInfoDTO) cr.uniqueResult();

		if (mdto != null) {

			ss.delete(mdto);
			ss.beginTransaction().commit();

			hss = req.getSession(false);
			String email = (String) hss.getAttribute("email");
			Criteria cr2 = ss.createCriteria(MailInfoDTO.class);
			cr2.add(Restrictions.eq("fromId", email));
			String status = "delete";
			cr2.add(Restrictions.eq("status", status));
			List<MailInfoDTO> mlist = cr2.list();
			if (mlist != null) {
				ss.close();
				return mlist;
			} else {
				ss.close();
				return null;
			}
		} else {
			ss.close();
			return null;
		}
	}

}
