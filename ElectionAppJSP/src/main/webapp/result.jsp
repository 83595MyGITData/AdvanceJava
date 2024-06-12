<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<hr>
<h1>Online Voting System</h1>
<hr>
<marquee>Announcement : ${Annlb.announce }</marquee>
<hr>

<jsp:useBean id="reslb" class="com.sunbeam.javabeans.CandidateListBean"></jsp:useBean>
${reslb.displayCandidate() }

<table border=1>
	<thead>
		<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Party</th>
		<th>Votes</th>
		<th>Edit</th>
		<th>Delete</th>
		</tr>
	</thead>
	<tbody>

<c:forEach var="c" items="${reslb.candList }">


		<tr>
			<td>${c.id}</td>
			<td>${c.name }</td>
			<td>${c.party }</td>
			<td>${c.votes }</td>
			<td><a href="edit.jsp?id=${c.id }"><img src="images/edit.png" alt="Edit" width="24" height="24"/></a></td>
			<td><a href="delete.jsp?id=${c.id }"><img src="images/delete.png" alt="Delete" width="24" height="24"/></a></td>
		</tr>
</c:forEach>
	</tbody>
</table>

<br><br>
<a href="announcement.jsp">Announcement</a>
<a href="index.jsp">LogOut</a>

</body>
</html>