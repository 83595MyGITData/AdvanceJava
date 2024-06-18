<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:setProperty name="product_bean" property="productId" value="productId" />
<jsp:setProperty name="product_bean" property="quantity" value="quantity" />
<body>
	<c:set var="status"
		value="${sessionScope.product_bean.purchaseProduct()}" scope="session" />
	<c:redirect url="/" />
</body>
</html>