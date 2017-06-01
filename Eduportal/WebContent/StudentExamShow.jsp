<%@page import="com.eduportal.model.ExamResultInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Exam</title>
<style type="text/css">
form
{
	float:left;
	
}
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

<% ArrayList<ExamResultInfo> elist=(ArrayList<ExamResultInfo>)request.getAttribute("examlist");
	HttpSession ses=request.getSession(false);
	String uname=(String)ses.getAttribute("sid");
%>

<br>

<%for(ExamResultInfo exam:elist)
	{%>
	
	<a href="ExamRequestServlet?test=<%=exam.getSubject() %>&sid=<%=uname%>&eno=<%= exam.getEno() %>"><%=exam.getSubject() %></a>
	<br>
	<%} %>
	
<br>
<a href="StudentHomepage.jsp">Home</a>

</body>
</html>