<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>welcome to my</h4><h4 style="color: red"> GMail</h4><br>
<hr>
<a href="Register">registration</a> | <a href="login">login</a>
<hr>
<h4>if you forgot your password try to enter your email</h4>
<h4>so that we can find your account</h4>
${msg }
<form action="ForgotPW" method="post">
		email:<input type="text" name="email" required="required"> 
		<input type="submit" value="submit">
	</form>
</body>
</html>