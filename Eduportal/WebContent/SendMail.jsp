<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.eduportal.model.BatchInfo" %>

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
<h1>SEND Mail</h1>
<br><br>

<% ArrayList<BatchInfo> blist=(ArrayList<BatchInfo>)request.getAttribute("batchlist"); %>


<form action="MailSendServlet" method="post">
<b>Enter Batch </b>&nbsp;
<select name="batch" id="batch">

<option>Select one</option>
<%
for(BatchInfo bobj:blist)
{

%>
<option><%=bobj.getBname() %></option>

<%} %>

</select>
<br>

Subject:<input type="text" name="subject">
<br>
Message:<input type="text" name="message">
<br>
Enter your mail password:<input type="password" name="pwd">
<br>

<input type="submit" value="send">
</form>
</body>
</html>