<%@page import="java.util.Base64"%>
<%@page import="com.pro.entity.Pet"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pro.connection.SessionCon"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	Session ss = new SessionCon().getConnection();
	String petId=request.getParameter("petId");
	//System.out.println("petid:"+petId);
	Criteria cr = ss.createCriteria(Pet.class);
	cr.add(Restrictions.eq("ID",Integer.parseInt(petId)));

	
	ArrayList<Pet> al = (ArrayList<Pet>) cr.list();
	
	for (Pet p : al) {
		
	     String base64Encoded = Base64.getEncoder().encodeToString(p.getImage());
		 String pic="data:image/jpg;base64,"+base64Encoded;
		 out.println("<img src='"+pic+"' alt='not showing'>");
	}
	%>
</body>
</html>