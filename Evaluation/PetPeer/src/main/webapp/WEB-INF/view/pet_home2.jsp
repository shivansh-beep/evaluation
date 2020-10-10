<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.pro.connection.SessionCon"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="com.pro.entity.Pet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales Management</title>
<link rel="stylesheet"
href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<br>
<div class="container">
	<div align="right" class="align-top">
	<div class="btn-group">
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    SearchPet
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="SearchByBreed">By Breed</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="SearchByAge">By Age</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="SearchByPlace">By Place</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="SearchByPrice">Price(Low-High)</a>
  </div>
  
</div>

		  <a href="myBasket"class="btn btn-primary">Basket</a>  <a class="btn btn-danger"
			href="Logout">Logout</a>
	</div>
	<hr>

	<%
	Session ss = new SessionCon().getConnection();
	Criteria cr = ss.createCriteria(Pet.class);
	ArrayList<Pet> al = (ArrayList<Pet>) cr.list();
	%>

	<h4 align="center">Pet Peers</h4>
	

		<table class="table table-bordered">
			<thead>
				<tr class="table-primary">
					<th scope="col">#</th>
					<th scope="col">Pet Name</th>
					<th scope="col">Place</th>
					<th scope="col">Age</th>
					<th scope="col">Breed</th>
					<th scope="col">price</th>
					<th scope="col">Action</th>

				</tr>
			</thead>
			<%
				for (Pet pet : al) {
			%>
			<tbody>

				<tr>
					<th scope="row"><center><%=pet.getID()%></center></th>
					<td><center><%=pet.getPET_NAME()%></center></td>
					<td><center><%=pet.getPET_PLACE()%></center></td>
					<td><center><%=pet.getPET_AGE()%></center></td>
					<td><center><%=pet.getBreed()%></center></td>
					<td><center><%=pet.getPrice()%></center></td>
					<%
						if (pet.getStatus().equalsIgnoreCase("available")) {	%>
				
					<td><center>
							
			<a class="btn btn-primary" href="addToBasket?petId=<%=pet.getID()%>"><font color="white">Add to Basket</font></a>
						
						</center></td>
					<%
						} else {
					%>
					<td><center>
							<button type="button" class="btn btn-primary" disabled>Not Available</button>
						</center></td>
					<%
						}
					%>
				</tr>
				<%} %>
			</tbody>

		</table>
	</div>

	<h5>${msg }</h5>
</body>
</html>


