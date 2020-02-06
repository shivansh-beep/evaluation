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
<hr>
<form action="searchOption" method="post">


<select name="searchBy"  required="required">
		<option value=""selected disabled>Search By</option>
		<option value="name">Product Name</option>
		<option value="category">category</option>
		<option value="company">company of the product</option>
		</select>
		
		<input type="text" name="product" required="required">
		<input type="submit" value="SEARCH">
		
		</form>
</body>
</html>