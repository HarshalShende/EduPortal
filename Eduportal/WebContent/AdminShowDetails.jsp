<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.eduportal.model.StudentInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify student details</title>
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

<%StudentInfo sobj=(StudentInfo)request.getAttribute("info"); %>
	
	<form action="UpdateInfo">
	
	<table width="40%" border="2" >
	<tr><td>StudentId: </td><td><label><%=sobj.getId() %></label></td></tr>
	<input type="hidden" id="roll" name="roll" value=<%=sobj.getId()%> >
	<tr><td>StudentName: </td><td><textarea name="sname" ><%=sobj.getFname() %></textarea></td></tr>
	<tr><td>UserName: </td><td><textarea name="uname" ><%=sobj.getUname() %></textarea></td></tr>
	<tr><td>Password: </td><td><textarea name="pwd" ><%=sobj.getPass() %></textarea></td></tr>
	<tr><td>Date of birth: </td><td><textarea name="dob" ><%=sobj.getDob() %></textarea></td></tr>
	<tr><td>Permanent Address: </td><td><textarea name="permaddr" ><%=sobj.getPermaddr() %></textarea></td></tr>
	<tr><td>Present Address: </td><td><textarea name="paddr" ><%=sobj.getPresentaddr() %></textarea></td></tr>
	<tr><td>Phone No: </td><td><textarea name="phno" ><%=sobj.getResPh() %></textarea></td></tr>
	<tr><td>Mobile: </td><td><textarea name="mob" ><%=sobj.getMob() %></textarea></td></tr>
	<tr><td>Email: </td><td><textarea name="email" ><%=sobj.getEmail() %></textarea></td></tr>
	</table>
<input type="submit" value ="Save">
</form><br>
<form action="DeleteStudent">
	<input type="hidden" name="sid" value=<%=sobj.getId()%> >
	<input type="submit" value ="Delete">
</form>
<a href="AdminHomepage.jsp">HOME</a>
</body>

</html>