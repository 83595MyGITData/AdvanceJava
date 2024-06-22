<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>List of Products</h5>

${prod_list}

<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>All Products</caption>
		<c:forEach var="post" items="${requestScope.prod_list}">
			<tr>
				<td>${post.id}</td>
				<td>${post.name}</td>
				<td>${post.price}</td>
				<td>${post.availQuantity}</td>
				
				
				<c:url var="url" value="/blogger/delete_post?postId=${post.id}" />
				<td><a href="${url}">purchase</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>