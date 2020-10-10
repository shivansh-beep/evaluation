<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div align="right">
		<a href="SellerHome">home</a>   <a href="Logout">Logout</a>
	</div>
	<hr>
	<div>${msg }</div>

	<div align="center" class="div1">Pet Peers</div>
	<div align="center" class="div2">add pet</div>
	<br>
	<form action="petData" method="post" class="col-sm-4" enctype="multipart/form-data">

		
		 <label>petname:</label>
		<input class="form-control" type="text" name="PET_NAME" required="required">
		 <label>age:</label>
		<input class="form-control" type="text" name="PET_AGE" required="required"> 
		<label>place:</label>
		<input class="form-control" type="text" name="PET_PLACE" required="required"> 
		<label>Breed:</label>
		<input class="form-control" type="text" name="breed" required="required"> 
		<label>Price:</label>
		<input class="form-control" type="text" name="price" required="required"> 
		<label>upload:</label>
		<input class="form-control" type="file"  name="file" >
	
		<br>
			 <input class="btn btn-success" type="submit" value="save">
			 <input class="btn btn-danger"	type="reset" value="cancel">

	</form>
</body>
</html>