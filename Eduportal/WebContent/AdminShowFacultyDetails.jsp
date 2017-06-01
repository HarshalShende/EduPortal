<%@page import="com.eduportal.model.FacultyInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Faculty Details</title>

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
<%FacultyInfo fobj=(FacultyInfo)request.getAttribute("info");  %>
	
	<form action="UpdateInfoFaculty">
	
	<table width="40%" border="2">
	
	<tr><td>FacultyId: </td><td><label><%=fobj.getId() %></label></td></tr>
	<input type="hidden" id="roll" name="roll" value=<%=fobj.getId()%> >
	<tr><td>StudentName: </td><td><textarea name="sname" ><%=fobj.getFname() %></textarea></td></tr>
	<tr><td>UserName: </td><td><textarea name="uname" ><%=fobj.getUname() %></textarea></td></tr>
	<tr><td>Password: </td><td><textarea name="pwd" ><%=fobj.getPass() %></textarea></td></tr>
	<tr><td>Date of birth: </td><td><textarea name="dob" ><%=fobj.getDob() %></textarea></td></tr>
	<tr><td>Permanent Address: </td><td><textarea name="permaddr" ><%=fobj.getPermaddr() %></textarea></td></tr>
	<tr><td>Present Address: </td><td><textarea name="paddr" ><%=fobj.getPresentaddr() %></textarea></td></tr>
	<tr><td>Phone No: </td><td><textarea name="phno" ><%=fobj.getResPh() %></textarea></td></tr>
	<tr><td>Mobile: </td><td><textarea name="mob" ><%=fobj.getMob() %></textarea></td></tr>
	<tr><td>Email: </td><td><textarea name="email" ><%=fobj.getEmail() %></textarea></td></tr>
	<tr><td>Subject: </td><td><textarea name="subject" ><%=fobj.getSubject() %></textarea></td></tr>
	<tr><td>Qualification: </td><td><textarea name="qual" ><%=fobj.getQual() %></textarea></td></tr>
	<tr><td>College: </td><td><textarea name="college" ><%=fobj.getCollege()%></textarea></td></tr>
	
	</table>
	<input type="submit" value ="save">
</form>
<form action="DeleteFaculty">
	<input type="hidden" name="sid" value=<%=fobj.getId()%> >
	<input type="submit" value ="Delete">
	
</form>
<a href="AdminHomepage.jsp">HOME</a>
</body>
</html>