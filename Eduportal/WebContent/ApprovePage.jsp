<%@page import="com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.eduportal.model.StudentInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve student</title>
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
<%! StudentInfo sob; %>

<% sob=(StudentInfo)request.getAttribute("sinfo"); %>

<form action="ApproveReject" method="get">
<input type="hidden" name="type" value="student">
<br>
<table>
<tr>
<th>Roll No</th>
<td><input type="text" name="roll" value=<%=sob.getId() %>></td>
</tr>

<tr>
<th>Name</th>
<td><%=sob.getName() %></td>

</tr>

<tr>
<th>Username</th>
<td><%=sob.getUname() %></td>
</tr>

<tr>
<th>Password</th>
<td><%=sob.getPass() %></td>
</tr>

<tr>
<th>DoB</th>
<td><%=sob.getDob() %></td>
</tr>

<tr>
<th>Gender</th>
<td><%=sob.getGender() %></td>
</tr>
<tr>
<th>Permanent Address</th>
<td><%=sob.getPermaddr() %></td>
</tr>

<tr>
<th>Present Address</th>
<td><%=sob.getPresentaddr() %></td>
</tr>

<tr>
<th>Phone No </th>
<td><%=sob.getResPh() %></td>
</tr>

<tr>
<th>Mobile</th>
<td><%=sob.getMob() %></td>
</tr>

<tr>
<th>Email</th>
<td><%=sob.getEmail() %></td>
</tr>

<tr>
<th>Entrance Exam Score</th>
<td><%=sob.getEscore() %></td>
</tr>
</table>

<input type="submit" name="approve" value="Approve">
&nbsp;
<input type="submit" name="reject" value="Reject">
</form>
</body>
</html>