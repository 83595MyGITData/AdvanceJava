<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Logic</title>
</head>
<body>
<jsp:useBean id="lb" class="com.sunbeam.javabeans.RegisterBean"/>
<jsp:setProperty name="lb" property="firstName" param="fname"/>
<jsp:setProperty name="lb" property="lastName" param="lname"/>
<jsp:setProperty name="lb" property="email" param="email"/>
<jsp:setProperty name="lb" property="password" param="password"/>
<jsp:setProperty name="lb" property="dob" param="dob"/>

<%lb.registerUser();%>


	<!-- <jsp:forward page="index.jsp"/> -->


</body>
</html>