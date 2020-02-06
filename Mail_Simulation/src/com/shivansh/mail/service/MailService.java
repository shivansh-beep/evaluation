package com.shivansh.mail.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shivansh.mail.model.MailInfoDTO;
import com.shivansh.mail.model.UserDTO;

public interface MailService {
public boolean register(UserDTO dto);
public boolean loginData(HttpServletRequest req);
public boolean sendMail(HttpServletRequest req);
public List<MailInfoDTO> sent(String uid);
public List<MailInfoDTO> draft(String email);
public List<MailInfoDTO> inbox(String fromMail);
public boolean password(UserDTO dto,HttpServletRequest req);
public List<UserDTO> Forgot(HttpServletRequest req);
public boolean Ans(HttpServletRequest req);
public boolean delete(HttpServletRequest req);
public List<MailInfoDTO> deletedMessages(HttpServletRequest req);
public List<MailInfoDTO> PermanantDelete(HttpServletRequest req);
}
