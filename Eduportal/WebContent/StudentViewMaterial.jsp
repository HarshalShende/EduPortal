<%@page import="com.eduportal.model.MaterialInfo"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Materials</title>
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
<body>
<h1>Materials </h1>

<br>
<table cellpadding="5" cellspacing="5">

<tr>
<th>Faculty</th>
<th>Material Download Link</th>
</tr>

 <% ArrayList<MaterialInfo> mlist=(ArrayList<MaterialInfo>)request.getAttribute("minfo");
 	
 	for(MaterialInfo mobj:mlist)
 	{ 
 %>

<tr>

<td><%=mobj.getFid() %></td>

<td>
<a href="StudentDownloadMaterialServlet?aloc=<%=mobj.getFileloc() %>" download><%=mobj.getFileloc() %></a>
</td>
</tr>

<%} %>

</table>
<a href="StudentHomepage.jsp">Home</a>
</body>
</html>