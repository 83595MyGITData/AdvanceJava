<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<hr>
<h1>Error</h1><hr>

<p>
Some error Occured....
</p>
Error:<%= exception.getMessage() %>

</body>
</html>