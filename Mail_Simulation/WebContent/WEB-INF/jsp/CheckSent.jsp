<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">welcome to </h1>
<h1 align="center" style="color: red">GMail</h1><br>
<h4 align="right" style="color: green">${msg }</h4>
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
<h4> To email:<%=request.getParameter("toId")%></h4>
<h4> Subject:<%=request.getParameter("subject")%></h4>
<h4> Message:<%=request.getParameter("message")%></h4>
<hr>
<a href="delete?id=<%=request.getParameter("id")%>">delete</a>
</body>
</html>