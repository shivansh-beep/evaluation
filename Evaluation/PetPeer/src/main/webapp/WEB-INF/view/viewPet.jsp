<%@page import="java.util.Base64"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="com.pro.entity.Pet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="com.pro.connection.SessionCon"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.pro.entity.PetUser"%>
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

<script>
	function getImg() {

		var petId = document.getElementById("id").value;
		var xhttp;
		xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("img").innerHTML = this.responseText;
			}
		};
		xhttp.open("Post","getImage?petId="+petId,true);
		xhttp.send();
	}
</script>
</head>


<body>
	<div class="container">
		<div align="right">
			<a href="pet_home2">home</a> <a href="Logout">Logout</a>
		</div>
		<hr>


		<h4 align="center">Pet Peers</h4>
		<div>

			<div class="col-sm-4">

				<p style="color: red">ID:</p>
				<p style="color: red">Pet Name:</p>
				<p style="color: red">Place:</p>
				<p style="color: red">Age:</p>
				<p style="color: red">Breed:</p>
				<p style="color: red">Price in Rupees:</p>
				<p style="color: red">Owner Phone:</p>
				<p style="color: red">Owner Email:</p>

				
				<div id="img" class="col-sm-4"></div>



			</div>
			<div class="col-sm-6">
				<form action="buy">
					<c:forEach var="mdto" items="${myPetList }">


						<p>
							<input id="id" name="petId" value="${mdto.getID()}" />
						</p>
						<p>
							<input id="name" value="${mdto.getPET_NAME()}" />
						</p>
						<p>
							<input id="place" value="${mdto.getPET_PLACE()}" />
						</p>
						<p>${mdto.getPET_AGE()}</p>
						<p>${mdto.getBreed()}</p>
						<p>${mdto.getPrice()}</p>
						<div id="txtHint"></div>
						<p>
							<input type="hidden" id="ownerId" name="ownerID"
								value="${mdto.getPET_OWNERID()}" />
						</p>
						<p>${mdto.getOwnerPhone()}</p>
						<p>${mdto.getOwnerEmail()}</p>

					</c:forEach>


					<br> <input type="submit" class="btn btn-primary" value="Buy" />
				</form>

				<button type="button" class="btn btn-success" onClick="getImg();">View
					Photo</button>




			</div>

			<style>
input {
	border-top-style: hidden;
	border-right-style: hidden;
	border-left-style: hidden;
	border-bottom-style: hidden;
}
</style>




		</div>
	</div>
</body>

</html>



