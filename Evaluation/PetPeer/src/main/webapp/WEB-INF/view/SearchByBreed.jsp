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
	<form action="byBreed">
	
		<select name="breed" id="breed">
			<%
				String breed = "";
			for (Pet pet : al) {
				if (!pet.getBreed().equals(breed)) {
			%>
			<option value="<%=pet.getBreed()%>"><%=pet.getBreed()%></option>
			</tr>
			<%
				}
			breed = pet.getBreed();
			}
			%>

		</select>
		<input type="hidden" name="doBy" value="breed">
		<input type="submit" value="search"> 
		</form>
	</div>
</body>
</html>