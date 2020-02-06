package com.shivansh.mail.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shivansh.mail.model.MailInfoDTO;
import com.shivansh.mail.model.UserDTO;
import com.shivansh.mail.service.MailService;

@Component
@RequestMapping("/")
public class MailController {
	@Autowired
	MailService ms;
	HttpSession hss;
	SessionFactory sf;
	RequestDispatcher rd;

	@RequestMapping("/Register")
	public String reg() {
		return "Register";
	}
	@RequestMapping("/CheckDraft")
	public ModelAndView CheckDraft(HttpServletRequest req) {
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (email == null) {
			return new ModelAndView("login", "msg", "login first");
		}else {
			return new ModelAndView("CheckDraft");
	}
	}
	
	@RequestMapping("/CheckSent")
	public ModelAndView CheckSent(HttpServletRequest req) {
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (email == null) {
			return new ModelAndView("login", "msg", "login first");
		}else {
		return new ModelAndView("CheckSent");
		}
	}

	@RequestMapping(value = "/registrationData", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute UserDTO dto) {
		boolean b = ms.register(dto);
		if (b) {
			return new ModelAndView("login", "msg", "signup Successfull ");
		} else {
			return new ModelAndView("Register", "msg", " email already exists..");
		}
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginData", method = RequestMethod.POST)
	public ModelAndView logUser(HttpServletRequest req) {
		String email = req.getParameter("email");
		boolean b = ms.loginData(req);
		if (b) {
			hss = req.getSession(false);
			hss.setAttribute("email", email);
			String userName = (String) hss.getAttribute("userName");
			return new ModelAndView("home", "msg", "logged in using :- " + userName);
		} else {
			return new ModelAndView("login", "msg", "login failed try again please... ");
		}
	}

	@RequestMapping("/compose")
	public ModelAndView compose(HttpServletRequest req) {

		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (email == null) {
			return new ModelAndView("login", "msg", "login first");
		} else {
			return new ModelAndView("compose");
		}
	}

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public ModelAndView send(HttpServletRequest req) {

		boolean b = ms.sendMail(req);
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");
		if (b) {
			return new ModelAndView("home", "msg", "Mail Successfull Sent");
		} else {
			return new ModelAndView("home", "msg", "Mail Send Failed");
		}
	}

	@RequestMapping("/Sent")
	public ModelAndView sentSuccess(HttpServletRequest req) {
		hss = req.getSession(false);
		String uid = (String) hss.getAttribute("email");
		if (uid != null) {
			List<MailInfoDTO> mlist = ms.sent(uid);
			return new ModelAndView("Sent", "mlist", mlist);
		} else {
			return new ModelAndView("login", "msg", "login first");
		}
	}

	@RequestMapping("/Draft")
	public ModelAndView draft(HttpServletRequest req) {
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");
		if (email != null) {
			List<MailInfoDTO> mlist = ms.draft(email);
			return new ModelAndView("Draft", "mlist", mlist);
		} else {
			return new ModelAndView("login", "msg", "login first");
		}
	}

	@RequestMapping("/inbox")
	public ModelAndView Inbox(HttpServletRequest req) {
		hss = req.getSession(false);
		String fromMail = (String) hss.getAttribute("email");
		if (fromMail != null) {
			List<MailInfoDTO> mlist = ms.inbox(fromMail);
			return new ModelAndView("inbox", "mlist", mlist);
		} else {
			return new ModelAndView("login", "msg", "login first");
		}

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req) {
		hss = req.getSession(false);
		if(hss!=null){
			
		String email = (String) hss.getAttribute("email");
			hss.invalidate();
		if (email == null) {
			return new ModelAndView("login", "msg", "login first");
		}	
		 else {
			return new ModelAndView("index", "msg", "logged out successfuly");
		}
		}else{
			return new ModelAndView("login", "msg", "login first");
		}
	}

	@RequestMapping("/Change")
	public ModelAndView changePassword(HttpServletRequest req) {
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (email != null) {
			return new ModelAndView("Change");
		} else {
			return new ModelAndView("login", "msg", "login first");
		}
	}

	@RequestMapping(value = "/ChangePW", method = RequestMethod.POST)
	public ModelAndView ChangePW(@ModelAttribute UserDTO dto, HttpServletRequest req) {

		boolean b = ms.password(dto, req);

		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (b) {
			return new ModelAndView("index", "msg", "password changed ");
		} else {
			return new ModelAndView("Change", "msg", " try again...");
		}
	}

	@RequestMapping("/Forgot")
	public String Forgot() {

		return "Forgot";
	}

	@RequestMapping("/ForgotPW")
	public ModelAndView ForgotPW(HttpServletRequest req) {
		hss = req.getSession(false);
		String uid = (String) hss.getAttribute("email");

		List<UserDTO> ulist = ms.Forgot(req);
		if (ulist != null) {
			return new ModelAndView("Que", "ulist", ulist);
		} else {
			return new ModelAndView("Forgot", "msg", "email not found");
		}
	}

	@RequestMapping("/Ans")
	public ModelAndView Ans(HttpServletRequest req) {
		boolean b = ms.Ans(req);
		if (b) {
			return new ModelAndView("Change", "msg", "Type a Strong Password");
		} else {
			return new ModelAndView("Que", "msg", " wrong answer..");
		}

	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req) {
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (email == null) {
			return new ModelAndView("login", "msg", "login first");
		} else{
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		hss = req.getSession(false);
		hss.setAttribute("id", id);
		boolean b = ms.delete(req);
		if(b){
		return new ModelAndView("home", "msg", "message deleted...");
		}else{
			return new ModelAndView("home", "msg", " Deleted Failed...");
		}
		}
	}
	@RequestMapping("/DeletedMessages")
	
	public ModelAndView deletedMessages(HttpServletRequest req) {
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (email == null) {
			return new ModelAndView("login", "msg", "login first");
		} else{
		List<MailInfoDTO> mlist=ms.deletedMessages(req);
		return new ModelAndView("DeletedMessages","mlist",mlist);
		}
	}
	
	@RequestMapping("/PermanantDelete")
	public ModelAndView PermanantDelete(HttpServletRequest req) {
		
		hss = req.getSession(false);
		String email = (String) hss.getAttribute("email");

		if (email == null) {
			return new ModelAndView("login", "msg", "login first");
		} else{
			String id=req.getParameter("id");
			int id1=Integer.parseInt(id);
			
			hss=req.getSession(false);
			hss.setAttribute("id", id1);
			
			List<MailInfoDTO> mlist= ms.PermanantDelete(req);
		if(mlist!=null){
		return new ModelAndView("DeletedMessages","mlist",mlist);
		}else{
			return new ModelAndView("home","msg","Deleted message is empty...");
		}
		}
	}
}
