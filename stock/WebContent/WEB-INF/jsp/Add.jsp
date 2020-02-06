<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Search">Search</a> |
<a href="View">view All</a> |
<a href=Add>AddProducts</a> |
<a href=viewCart>View Cart</a> |
<a href=logout>LogOut</a>
<hr>
<h1>${msg }</h1>
<form action="addProduct" method="post">

<input type="text" name="name" placeholder="name" required="required"><br>
<input type="text" name="quantity" placeholder="quantity"  required="required"><br>
<input type="text" name="company" placeholder="company"  required="required"><br>
<input type="text" name="category" placeholder="category"  required="required"><br>
<input type="text" name="price" placeholder="price"  required="required"><br>
<input type="submit" value="SAVE">
</form>

</body>
</html>