<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>

<%
HttpSession session1=request.getSession();
session1.invalidate();
%>

<h1>Thankyou for saving Democracy....
</h1>
<center><a href="index.jsp">Login Again</a>

</body>
</html>