<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<style><%@include file="/WEB-INF/view/userregn.css"%></style>
</head>
<body>
<div align="right"><a href="index.jsp">HOME</a>  <a href="Login">Login</a> <a href="">User Registraion</a></div>
<hr>
<div>${msg }</div>

	<div class="div1">Pet Peers</div>
	<div class="div2">Sign Un</div>
	<div id='container'>
	 <div class='signup'>
	<form action="registered"  method="post">
	
		
				<!-- Enter Username -->
				<!-- <label>Username:</label> -->
			<input type="text" name="userName" placeholder='username' required="required">
			
			<input type="text" name="phone" placeholder='phone' required="required">
			
			<input type="text" name="email" placeholder='email id' required="required">
		
		
				<!-- Enter Password. -->
			<!-- 	<label>Password:</label> -->
			<input type="password" name="password1" placeholder='password' required="required">		
	
				<!-- To Confirm Password. -->
				<!-- <label>Confirm Password:</label> -->
				<input type="password" name="password2" placeholder='confirm password' required="required">
				
				<input type="radio" id="seller" name="type" value="seller">
				<label for="seller">Seller    </label>  
				<input type="radio" id="buyer" name="type" value="buyer">
				<label for="buyer">Buyer</label><br> 
				
			<input type="submit" value="Submit">
			<input type="reset" value="Reset">
		
	</form>
	</div>
	</div>
</body>
</html>
