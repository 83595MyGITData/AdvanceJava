<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>

<jsp:useBean id="dlb" class="com.sunbeam.javabeans.DeleteCandidateBean"></jsp:useBean>
<jsp:setProperty name="dlb" property="id" param="id" />
${dlb.DeleteCand() }

<c:choose>
		<c:when test="${dlb.count == 1}">
			
			<c:redirect url="result.jsp"></c:redirect>
			
		</c:when>
		<c:otherwise>
			Candidate delete failed. <br/><br/>
			<a href="result.jsp">Show Result</a>
		</c:otherwise>
	</c:choose>

</body>
</html>