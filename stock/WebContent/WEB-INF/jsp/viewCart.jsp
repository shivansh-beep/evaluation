<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 
<center><table border='1' style="color: blue"><tr><th>Order ID</th><th>Product Name</th><th>Product Category</th><th>Company Name</th> <th>Quantity</th><th>Price</th><th>Total Price</th><th>Total Price With GST</th></tr>
<c:forEach var="odto" items="${olist}">
<c:forEach var="pdto" items="${odto.getPlist()}">
<tr><td><center>${odto.getOid()}</center></td>
<td><center>${pdto.getName() }</center></td>
<td><center> ${pdto.getCategory() }</center></td>
<td><center>${pdto.getCompany() }</center></td>
<td><center>${odto.getTotal_price()/pdto.getPrice() }</center></td>
<td><center>${pdto.getPrice() }</center></td> 

</c:forEach>
<td><center>${odto.getTotal_price() }</center></td> 
<td><center>${odto.getTotal_price_with_gst() }</center></td> </tr>
</c:forEach>
</table>
</center>
</body>
</html>