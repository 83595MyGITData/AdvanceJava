<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login User</title>
</head>
<body>

<jsp:useBean id="lb" class="com.sunbeam.javabeans.LoginBean"/>
<jsp:setProperty name="lb" property="email" param="email"/>
<jsp:setProperty name="lb" property="password" param="password"/>
<%lb.authenticate();%>

<%if(lb.getUsr()!=null ){ %> 
	Welcome, <jsp:getProperty name="lb" property="email" />
	<jsp:forward page="candlist.jsp"/> 
<%}else{ %>
	Login Failed...
<% }%>
</body>
</html>