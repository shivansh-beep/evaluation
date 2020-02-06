package com.shivansh.mail.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shivansh.mail.dao.MailDao;
import com.shivansh.mail.model.MailInfoDTO;
import com.shivansh.mail.model.UserDTO;

@Component
public class MailServiceImp implements MailService {

	@Autowired
	MailDao md;

	@Override
	public boolean register(UserDTO dto) {
		// TODO Auto-generated method stub
		boolean b = md.register(dto);
		return b;
	}

	@Override
	public boolean loginData(HttpServletRequest req) {
		return md.loginData(req);
	}

	@Override
	public boolean sendMail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		boolean b = md.sendMail(req);
		return b;
	}

	@Override
	public List<MailInfoDTO> sent(String uid) {
		// TODO Auto-generated method stub

		return md.sent(uid);
	}

	public List<MailInfoDTO> draft(String email) {
		// TODO Auto-generated method stub
		return md.draft(email);
	}

	@Override
	public List<MailInfoDTO> inbox(String fromMail) {
		// TODO Auto-generated method stub

		return md.inbox(fromMail);
	}

	public boolean password(UserDTO dto, HttpServletRequest req) {
		return md.password(dto, req);
	}

	public List<UserDTO> Forgot(HttpServletRequest req) {
		return md.Forgot(req);
	}

	public boolean Ans(HttpServletRequest req) {
		return md.Ans(req);
	}

	public boolean delete(HttpServletRequest req) {
		return md.delete(req);
	}
	
	public List<MailInfoDTO> deletedMessages(HttpServletRequest req){
		return md.deletedMessages(req);
	}
	public List<MailInfoDTO> PermanantDelete(HttpServletRequest req){
		return md.PermanantDelete(req);
	}
}
