<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center" >
<h1>registration page..</h1>
	 <fieldset>
 <style>
 fieldset{
 width:351px;
 }
 </style>
	<form action="registrationData" method="post">
	<pre>
Name :<input type="text" name="name" required="required"><br>
email*:    <input type="email" name="email" required="required"> <br>
password*: <input type="text" name="password" required="required"><br>

<input type="submit" value="registerData"> | <a href="Login2">login</a>
</pre>
	</form>
	</fieldset>
	${msg }
	
	</div>
</body>
</html>