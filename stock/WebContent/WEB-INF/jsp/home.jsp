<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h4>stock management</h4>
<h3> ${msg}</h3>
<hr>
<div align="right">
<a href="Search">Search</a> |
<a href="View">view All</a> |
<a href=Add>AddProducts</a> |
<a href=viewCart>View Cart</a> |
<a href=logout>LogOut</a>
</div>
<hr>
<!-- The user can add product to a cart and generate a bill for the products list present in the
cart, the quantity has to be reduced in the DB once the bill is generated -->
</body>
</html>