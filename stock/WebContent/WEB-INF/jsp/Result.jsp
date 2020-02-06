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

<center><table border='1'><tr><th>&nbsp;</th> <th>product name</th> 
<th>price per unit</th><th>company</th>  <th>quantity</th></center></tr>

<c:forEach var="dto" items="${plist }">

<form action="order" method='post'>
<tr><td><input type='hidden' name='pid' value='${dto.getPid() }'/></td><td>${dto.getName() }</td>
<td>${dto.getPrice() }</td><td>${dto.getCompany() }</td><td><input type='text' size='3' value='1' name='qty'>
</td><td><input type='submit' value='Add To Cart' ></td>
</form>


<form action="modifyProduct" method="post">
<input type="hidden"  name="id" value=${dto.getPid() }>
<input type="hidden" name="name" value="${dto.getName() }"><br>
<input type="hidden" name="quantity" value="${dto.getQuantity() }"><br>
<input type="hidden" name="company" value="${dto.getCompany() }" ><br>
<input type="hidden" name="category" value="${dto.getCategory() }"><br>
<input type="hidden" name="price" value="${dto.getPrice() }"><br>
<td><input type="submit" value="Modify"></td></tr>

<%-- 
${dto.getName() }
${dto.getCategory() }
${dto.getPrice() }
${dto.getCompany() }
${dto.getQuantity() }
 --%>


</form>


</c:forEach>
</table>
</body>
</html>