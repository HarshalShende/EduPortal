<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<a href="AdminHomepage.jsp">Home</a>
<br>
<h1>ADD NEW SUBJECTS</h1>
<br><br>

<form action="AddSubjectServlet" method="get">
<table>
<tr>
<th>
Subject Code:&nbsp;
</th>
<td><input type="text" name="scode">
</td>
</tr>

<tr>
<th> Subject Name</th>
<td><input type="text" name="sname"></td>
</tr>

<tr>
	<th>Semester</th>
	<td><input type="text" name="sem"></td>
</tr>
</table>

<input type="submit">

</form>

</body>
</html>