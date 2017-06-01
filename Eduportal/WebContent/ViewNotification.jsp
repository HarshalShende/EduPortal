<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@page import="com.eduportal.model.NotificationInfo" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="b.jpg">

<% 
	ArrayList<NotificationInfo> nlist;
	nlist=(ArrayList<NotificationInfo>)request.getAttribute("notification");	
	
%>

	<table cellpadding="2" border="2">
		
			<th>Subject</th>
			<th>Message</th>
			<th>Sent by</th>
		
<%for(NotificationInfo ninfo:nlist)
{
%>
	<tr>
		<td><%= ninfo.getHeading()%></td>
		<td><%= ninfo.getMessage()%></td>
		<td><%= ninfo.getTag()%></td>
		
	</tr>

<%} %>
	</table>
	
	<br><br>
	<a href="StudentHomepage.jsp">Home</a>
</body>
</html>