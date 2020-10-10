package com.pro.connection;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionCon {


	private static Session ss = null;
	
	public SessionCon() {
	}

	public static Session getConnection() {
		SessionFactory sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		if (ss == null) {
		
			Session sh=sf.openSession();
		ss=sh;
		}
		return ss;
	}

}
