package com.shivansh.mail.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserDTO {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
private int uid;
private String userName;
private String email;
private String password;
private String securityQue;
private String securityAns;


@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(referencedColumnName="uid")
private List<MailInfoDTO> mlist;


public int getUid() {
	return uid;
}


public void setUid(int uid) {
	this.uid = uid;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public List<MailInfoDTO> getMlist() {
	return mlist;
}


public void setMlist(List<MailInfoDTO> mlist) {
	this.mlist = mlist;
}


public String getSecurityQue() {
	return securityQue;
}


public void setSecurityQue(String securityQue) {
	this.securityQue = securityQue;
}


public String getSecurityAns() {
	return securityAns;
}


public void setSecurityAns(String securityAns) {
	this.securityAns = securityAns;
}



}
