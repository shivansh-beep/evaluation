<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center" style="  background-color: aqua">
<h1>registration page..</h1>
	 <fieldset>
 <style>
 fieldset{
 width:351px;
 }
 </style>
	<form action="registrationData" method="post">
	<pre>
user name :<input type="text" name="userName" required="required"><br>
password*: <input type="text" name="password" required="required"><br>
email*:    <input type="email" name="email" required="required"> <br>
		
securityQue:<select  name="securityQue" id="question" required="required">
		<option value=""selected disabled>Security Question</option>
		<option value="whats's your father's name?">whats's your father's name?</option>
		<option value="hats's your pet name?">whats's your pet name?</option>
		<option value="hats's your son's name?">whats's your son's name?</option>
		<option value="whats's your fav. colour?">whats's your fav. colour?</option>
		</select>
		<br>
securityAns*:<input type="text" name="securityAns" required="required"> <br>
<input type="submit" value="register">| <a href="login">login</a>
</pre>
	</form>
	</fieldset>
	${msg }
	
	</div>
</body>
</html>