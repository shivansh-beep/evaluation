<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div align="center">Sign In</div>
<div class="container">
<div align="right"><a href="index.jsp">HOME</a></div>
<hr>
<div>${msg }</div>
 
	
	<br>
	
	
	<form class="col-sm-4"  action="signIn"  method="post" >
	
		<div class="form-group">
				<!-- Enter Username -->
				<label>Username:</label>
			<input class="form-control" type="text" name="userName" required="required">
		</div>
		
		<div  class="form-group">
				<!-- Enter Password. -->
				<label>Password:</label>
			<input class="form-control" type="password" name="password" required="required">		
	
		</div>
				<div class="form-group">
			<input class="btn btn-primary" type="submit" value="login">
			<input class="btn btn-danger" type="reset" value="Reset">
			</div>
		
	</form>
	
	</div>

</body>
</html>