<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Homepage</title>

<script>
$(document).ready(function() 
       {
          function disableBack() { window.history.forward() }

          window.onload = disableBack();
          window.onpageshow = function(evt) 
                              { if (evt.persisted) disableBack() }
        });
</script>

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
input[type=button], input[type=submit], input[type=reset],button {
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
	String uname=(String)ses.getAttribute("fid");
	if(uname==null){
	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	rd.forward(request,response);
	}
%>

<h2>Welcome <%=uname %></h2>


<div align="right"> <a href="LogoutServlet">Logout</a> </div>

<div align="left"><a href="FacultyChangePassword.html">Change Password</a></div>

<button onclick="location.href='UploadQuestionExcel.jsp';">Set Questions</button>
<button onclick="location.href='UploadAttendance.jsp';">Upload Attendance</button>
<button onclick="location.href='FacultySetAssignment.jsp';">Set Assignments</button>
<form action="FacultyFetchAssignmentServlet">
<input type="submit" value="View/Modify Assignment">
</form>
<button onclick="location.href='FacultyUploadMaterial.jsp';">Upload Material</button>
<form action="GetBatchesServlet">
<input type="hidden" name="next" value="FacultySetExam.jsp">
<input type="submit" value="Set Exams">
</form>

<form action="FacultyGetExamServlet">
<input type="submit" value="Modify Exam Date">
</form>

<form action="GetBatchesServlet">
<input type="hidden" name="next" value="FacultyExamResult.jsp">
<input type="submit" value="See Exam Results">
</form>
<form action="FacultyViewAssignmentsServlet">
<input type="submit" value="View Assignments">
</form>
<form action="SendNotificationServlet">
<input type="submit" value="Send Notification">
</form>
<form action="SendMail">
<input type="submit" value="Send Mail">
</form>
<form action="Video">
	<input type="submit" value="Capture Screen">
</form>
</body>
</html>