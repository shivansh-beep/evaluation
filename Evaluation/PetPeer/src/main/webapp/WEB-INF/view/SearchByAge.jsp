<%@page import="com.pro.connection.SessionCon"%>
<%@page import="com.pro.entity.Pet"%>
<%@page import="java.util.ArrayList"%>
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
	Criteria cr = ss.createCriteria(Pet.class);
	ArrayList<Pet> al = (ArrayList<Pet>) cr.list();
	%>

	<h4 align="center">Pet Peers</h4>
	<div align="center">
	<form action="byAge">
	<label>list of available pet's ages in months</label>
		<select name="age" id="age">
			<%
				String age = "";
			for (Pet pet : al) {
				if (!pet.getPET_AGE().equalsIgnoreCase(age)) {
			%>
			<option value="<%=pet.getPET_AGE()%>"><%=pet.getPET_AGE()%></option>
			</tr>
			<%
				}
			age = pet.getPET_AGE();
			}
			%>

		</select>
		<input type="hidden" name="doBy" value="Age">
		<input type="submit" value="search"> 
		</form>
	</div>
</body>
</html>