<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pro.entity.Pet"%>
<%@page import="com.pro.connection.SessionCon"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pet Sales Management</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div align="right">
			<a href="pet_home2">home</a> <a href="Logout">Logout</a>
		</div>
		<hr>


		<h4 align="center">Pet Peers</h4>
		<h4 align="center">My Basket</h4>
		<div>

			<table class="table table-bordered">
				<tr>
					<th style="color: red"><center>#</center></th>
					<th style="color: red"><center>Pet Name</center></th>
					<th style="color: red"><center>Place</center></th>
					<th style="color: red"><center>Age</center></th>
					<th style="color: red"><center>Breed</center></th>
					<th style="color: red"><center>Price in Rupees</center></th>
					<th style="color: red"><center>View</center></th>

				</tr>
				<c:forEach var="mdto" items="${myPetBasket }">
					<form action="viewPet">
					<tr>
						<td><center>
							<center>${mdto.getCartID()}</center>
								<input type="hidden" name="petId" value="${mdto.getPetID()}" id="id" />
							</center></td>
						<td><center>${mdto.getPET_NAME()}</center></td>
						<td><center>${mdto.getPET_PLACE()}</center></td>
						<td><center>${mdto.getPET_AGE()}</center></td>
						<td><center>${mdto.getBreed()}</center></td>
						<input name="ownerid" value="${mdto.getPET_OWNERID()}" type="hidden"/>
						<td><center>${mdto.getPrice()}</center></td>
						<td><center>



								<input type="submit" class="btn btn-primary" value="view">
								<style>
#id {
	border-top-style: hidden;
	border-right-style: hidden;
	border-left-style: hidden;
	border-bottom-style: hidden;
	
	width: 20px;
}
</style>
							</center></td>
						</form>
					</tr>
				</c:forEach>
			</table>
			<h4>${msg }</h4>
		</div>
	</div>
</body>

</html>


