<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h4>LogIn Here...</h4>
<h4 style="color: green">${msg }</h4>
<hr>
 <div align="center">
 <fieldset>
 <style>
 fieldset{
 width:351px;
 }
 </style>
 <pre>
<form action="loginData" method="post">
   email:<input type="text" name="email" required="required"> <br>
password:<input type="text"name="password" required="required"> <br>
<input type="submit" value="login"> | <a href="Register">registration</a>
</form>

	</pre>
	</fieldset>
	</div>
</body>
</html>