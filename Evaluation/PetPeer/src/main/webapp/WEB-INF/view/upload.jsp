<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>

<body>

<h4>${msg }</h4>
<hr>

	<div align="right">
		<a href="SellerHome">home</a>   <a href="Logout">Logout</a>
	</div>
	<hr>
	<div class="div1">Pet Peers</div>
	<div class="div2">add photo</div>
	<form action="uploadFile" method="post" enctype="multipart/form-data">

		
		
		
		<input type="file"  name="file" >
		<input type="hidden" name="pid" value="${pid }">
			 <input type="submit" value="save">
			 <input
			type="reset" value="cancel">

	</form>
</body>
</html>