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
<marquee>Announcement : ${Annlb.announce }</marquee>
<hr>
Hi, ${ lb.user.firstName }
<hr>
	
	<br>

<jsp:useBean id="vlb" class="com.sunbeam.javabeans.VoteBeans"></jsp:useBean>
<!-- <jsp:useBean id="lb" class="com.sunbeam.javabeans.LoginBean" scope="session"/>  -->


<jsp:setProperty name="vlb" property="id" param="id" />
<jsp:setProperty name="vlb" property="uid" param="${ lb.user.id }" />

	


<c:choose>
<c:when test="${lb.user.status == 0}">
	${ vlb.castVote() }
	
	
	Vote Casted Successfully..
	
	${ lb.updateStatusUser() }
	
	
	Thank you for Saving Democracy>>>
	<br><br>
	<a href="logout.jsp">Logout</a>
</c:when>
<c:otherwise>
	Already Vote is Casted....
	
<a href="logout.jsp">Logout</a>
	
</c:otherwise>
</c:choose>

</body>
</html>