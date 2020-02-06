<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>compose</title>
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
<h1>Compose Message...</h1>
<hr>
 <div align="center">
 <pre>
<form action="sendMail" method="post">
     to:<input type="email" name="email"  required="required"><br>
subject:<input type="text" name="subject"  placeholder="Type Here...."><br>
Message :<br><textarea rows="4" cols="30" name="message" >Type here..</textarea><br>
<input type="submit" name=send>
<hr>
</form>
</pre>
</div>
</body>
</html>