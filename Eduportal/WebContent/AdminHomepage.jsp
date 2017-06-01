<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body background="b.jpg">

<% HttpSession ses=request.getSession(false);
//System.out.println(ses);
	String uname=(String)ses.getAttribute("type");
	if(uname==null){
	RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.html");
	rd.forward(request,response);
	}
%>



<h1>ADMIN HOMEPAGE</h1>
<div align="right"><a href="AdminLogoutServlet">Logout</a></div>

<div align="left"><a href="AdminChangePassword.html">Change Password</a></div>
<br>
<br>
<form action="ViewApproval"method="get">
<input type="submit" value="View Pending Students">
</form>
<form action="ViewApprovalFaculty" method="get">
<input type="submit" value="View Pending Faculty">
</form>
<input type="button" onclick="window.location='AdminEmailSend.html'" value="Send E-mail">
<form action="AdminCheckMsgServlet" method="get">
<input type="submit" value="Check Query Messages">
</form>
<input type="button" onclick="window.location='AdminAddSubject.jsp'" value="Add Subjects">
<form action="AdminUpdateSemesterServlet">
<input type="submit" value="Update Semester">
</form>
<form action="AdminModifyStudentServlet" method="get">
<input type="submit" value="ModifyStudent">
</form>
<form action="AdminModifyFacultyServlet" method="get">
<input type="submit" value="ModifyFaculty">
</form>
</body>
</html>