<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>

<hr>
<h1>Online Voting System</h1>
<hr>
<jsp:useBean id="elb" class="com.sunbeam.javabeans.EditCandidateBean"></jsp:useBean>
<jsp:setProperty name="elb" property="id" param="id" />

${elb.fetchCandidate() }

<form method='post' action='update.jsp'>

 <input type="hidden" name='id' value=${elb.candidate.id }>
Name : <input type="text" name='name' value=${elb.candidate.name }> </br></br>
Party : <input type="text" name='party' value=${elb.candidate.party }> </br></br>
Votes : <input type="Email" name='votes' value=${elb.candidate.votes } readonly="readonly"> </br></br>

<input type="submit" value="Update">

</body>
</html>