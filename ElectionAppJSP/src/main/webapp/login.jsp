<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>

<jsp:useBean id="lb" class="com.sunbeam.javabeans.LoginBean" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="lb"/>

${ lb.authenticate() }



<c:choose>
	<c:when test="${lb.user.role == 'voter'}">
		<c:redirect url="candlist.jsp"/> 
	</c:when>
	<c:when test="${lb.user.role == 'admin'}">
		<c:redirect url="result.jsp"/>
	</c:when>
</c:choose>


</body>
</html>