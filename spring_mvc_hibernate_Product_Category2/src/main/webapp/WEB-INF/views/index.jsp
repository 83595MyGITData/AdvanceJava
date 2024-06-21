<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		Welcome !
	</h5>
	<h5>
		<c:url var="url" value="/posts/view?n1=100&n2=1000" />
		<a href="${url}">Test Model Map with Request Parameters</a>
	</h5>
</body>
</html>