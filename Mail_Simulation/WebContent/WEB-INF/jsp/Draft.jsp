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
<h1 align="center">welcome to </h1>
<h1 align="center" style="color: red">GMail</h1><br>
<hr>
 <div align="right" style="  background-color: aqua">
<a  href="inbox">inbox</a> |
<a href="Sent">sent</a> |
<a href="Draft">draft</a> |
<a  href="compose">compose</a> |
<a href="logout">logout</a> |
<a href="Change">change password</a>
<a href="DeletedMessages">Deleted Messages</a>
</div>
<hr>
<center><h1>Draft messages</h1></center>
<h3><center><table>
<style>
table{
    text-align: center;
    font-size: 15px;
     font-family: cursive ;
     border-radius: 25px;
      cursor: pointer;

}td{
    text-align: center;
    font-size: 15px;
     font-family: cursive ;
     border-radius: 25px;
      cursor: pointer;
    background-color: rgb(250, 186, 218);

}
th{
 text-align: center;
    font-size: 15px;
     font-family: cursive ;
     border-radius: 25px;
      cursor: pointer;
    background-color: rgb(18, 231, 231);
}
</style>
<tr><th>To Email</th>
<th style="color: red">Subject</th>
<th style="color: red">Delete</th></tr>

<c:forEach var="mdto" items="${mlist}">
<form action="CheckDraft" method="get">
<input type="hidden"  name="id" value=${mdto.getId() }>
  <input type="hidden"  name="fromId" value="${mdto.getFromId() }">
   <input type="hidden"  name="message" value="${mdto.getMessage() }">
    <input type="hidden"  name="subject" value="${mdto.getSubject() }">
     <input type="hidden"  name="toId" value="${mdto.getToId() }">
        <input type="hidden"  name="status" value="${mdto.getStatus() }">
        
<tr><td><center>${mdto.getToId() }</center></td>
<td><center><input type="submit" value="${mdto.getSubject() }">
<style>
input[type="submit"] {
  background: none;
  border: none;
  outline: none;
  text-decoration: underline;
  color: blue;
  cursor: pointer;
}
input[type="submit"]:hover {
  color: green;
}
</style>
<td><center><a href="delete?id=${mdto.getId() }">delete</a></center></td></tr>
</c:forEach>
</table>
</body>
</html>