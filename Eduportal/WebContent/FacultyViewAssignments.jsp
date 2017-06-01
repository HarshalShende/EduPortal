<%@page import="com.eduportal.model.AssignmentSubmissionInfo"%>
<%@page import="com.eduportal.model.AssignmentInfo"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
	font-family: Georgia;
	font-size: x-large;
	font-style: normal;
	font-variant: normal;
	color: #003366;

}
	a:hover {
    color: white;
    font-size: large;
	}
input[type=text] {
    background-color: #FDFACB;
    color: blue;
}
input[type=password] {
    background-color: #FDFACB;
    color: blue;
}
input[type=button], input[type=submit], input[type=reset] {
    background-color: #003366;
    border: none;
    color: white;
    padding: 16px 16px;
    text-decoration: none;
    margin: 2px 2px;
    cursor: pointer;
}

</style>

</head>
<body background="b.jpg">

<h1>Assignments </h1>

<br>
<table cellpadding="5" cellspacing="5">

<tr>
<th>Student Id</th>
<th>Assignment Download Link</th>
<th>Date of uploading</th>
</tr>

 <% ArrayList<AssignmentSubmissionInfo> alist=(ArrayList<AssignmentSubmissionInfo>)request.getAttribute("assinfo");
 	
 	for(AssignmentSubmissionInfo aobj:alist)
 	{
 	
 
 %>




<tr>

<td><%=aobj.getSid() %></td>

<td>
<a href="FacultyDownloadAssignmentServlet?aloc=<%=aobj.getFileloc() %>" download><%=aobj.getFileloc() %></a>
</td>

<td><%=aobj.getDate() %></td>
</tr>

<%} %>

</table>

</body>
</html>