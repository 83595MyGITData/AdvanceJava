<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annnouncement</title>
</head>
<body>

<jsp:useBean id="Annlb" class="com.sunbeam.javabeans.AnnouncementBean" scope ="application"></jsp:useBean>
<jsp:setProperty name="Annlb" property="*" />



<jsp:forward page="result.jsp"/>

</body>
</html>