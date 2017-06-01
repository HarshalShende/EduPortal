<%@page import="com.eduportal.model.ExamResultInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<% ArrayList<ExamResultInfo> elist=(ArrayList<ExamResultInfo>)request.getAttribute("elist");


%>

<table border="1" width="100%">
<tr>
<th>Exam No</th>
<th>Subject</th>
<th>Expiry Date</th>
</tr>

</table>

<%for(ExamResultInfo ob:elist)
	{%>
	<form action="FacultyModifyExamDate">
	<table width="100%">
	<tr>
	<td><input type="text" name="eno" value="<%=ob.getEno() %>" readonly="readonly"></td>
	<td><input type="text" name="sub" value="<%=ob.getSubject() %>" readonly="readonly"></td>
	<td><input type="date" name="edate" value="<%=ob.getEdate() %>"></td>
	<td><input type="submit" value="Modify">
	</tr>
	
	</table>
	<%} %>
	
	
	</form>
	

</body>
</html>