<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Syntax</title>
</head>
<body>

<%!
int count=1;
Date now = new Date();
%>

<br>

<%count=count+1;
out.println("Time: " + now);
%>

<br><br>
<%if(count%2==0){%>
Even count  <%= count %>
<%}else{ %>

Odd count= <%= count %>
<%
}%>

<br>
<%
if (count%2==0)
	out.println("Even count:"+count);
else
	out.println("Odd count:"+count);
%>
</body>
</html>