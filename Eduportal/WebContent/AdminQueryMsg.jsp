<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.eduportal.model.QueryMsgInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query Messages</title>
</head>
<body background="b.jpg">
<% List<QueryMsgInfo> qlist=(ArrayList<QueryMsgInfo>) request.getAttribute("querylist");
	
%>

<table border="5">
<tr>
<th>Name</th>
<td></td>
<th>E-mail Id</th>
<td></td>
<th>Message</th>
</tr>

<%for(QueryMsgInfo qobj:qlist)
	{
	
	String sname=qobj.getSndrName();
	String smail=qobj.getSndrMail();
	String smsg=qobj.getSndrMsg();%>
	
	<tr>
	<td><%= sname%></td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td><%= smail %></td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td width="50"><%= smsg %></td>
	</tr>
	
	<%} %>

</table>

<a href="AdminHomepage.jsp"><b>Home</b></a>
</body>
</html>