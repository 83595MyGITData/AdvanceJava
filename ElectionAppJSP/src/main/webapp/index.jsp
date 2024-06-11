<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<hr>
<h1>${initParam.Title}</h1>
<hr>

<form method="post" action="login.jsp" >

Email:<input type="email" name="email">
<br><br>
Password:<input type="password" name="password">
<br><br>

<input type="submit" value="Login">
<br><br>
New Users Click here to
<a href="newuser.jsp" >Register</a>



</form>

</body>
</html>