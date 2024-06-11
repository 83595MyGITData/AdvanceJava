<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>candlist</title>
</head>
<body>
<hr>
<h1>${initParam.Title}</h1>
<hr>

<jsp:useBean id="clb" class="com.sunbeam.javabeans.CandidateListBean"></jsp:useBean>

${ clb.displayCandidate() }

<form method="post" action="vote.jsp">

<c:forEach var="c" items="${clb.candList}">
	<input type="radio" name="candidate" value="${c.id}"/>${c.name} - ${c.party} <br>
</c:forEach>

<br><br>

<input type="submit" value ="vote">
</form>

</body>
</html>