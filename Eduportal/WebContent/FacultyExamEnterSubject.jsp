<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%ArrayList<String> sublist=(ArrayList<String>)request.getAttribute("sublist");
String batch=(String)request.getAttribute("batch");

%>

<form action="SetExamServlet">

<input type="hidden" name="batch" value="<%=batch %>">
Subject:&nbsp;
<select name="subject">

<%for(String sub:sublist){ %>
<option><%=sub %></option>

<%} %>
</select>

<br><br>

Last Date of exam:&nbsp;
<input type="date" name="lastdt">
<br><br>
<input type="submit" value="Set Exam">

</form>

</body>
</html>