<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
<hr>
<h1>${initParam.Title}</h1>
<hr>

<jsp:useBean id="vlb" class="com.sunbeam.javabeans.VoteBeans"></jsp:useBean>
<jsp:useBean id="lb" class="com.sunbeam.javabeans.LoginBean"/>
<jsp:setProperty name="vlb" property="uid" value="${user.id}"/>
<jsp:setProperty name="vlb" property="id"  param="candidate"/>



<c:choose>
<c:when test="${lb.user.status == 0}">
	${ vlb.castVote() }
	
	Vote Casted Successfully..
	
	
	Thank you for Saving Democracy>>>
	<br><br>
	<a href="logout.jsp">Logout</a>
</c:when>
<c:otherwise>
	Vote not done
	
</c:otherwise>
</c:choose>

</body>
</html>