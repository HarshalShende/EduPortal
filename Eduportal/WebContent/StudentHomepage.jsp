<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.eduportal.model.NotificationInfo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Homepage</title>

<script type="text/javascript">
$(document).ready(function() 
	       {
	          function disableBack() { window.history.forward() }

	          window.onload = disableBack();
	          window.onpageshow = function(evt) 
	                              { if (evt.persisted) disableBack(); }
	        });
        
function myf()
{
	//HttpSession ses=request.getSession(false); 
	//var noti = ses.getAttribute("notification");
	
	var he=document.getElementsByName("heading");
	var me=document.getElementsByName("message");
	for(i=0;i<he.length;i++)
		{
		var f=new Notification(he[i].value,{body:me[i].value});
		f.onclick = function()	{
			location.href="ViewNotificationServlet";
		}
		}
		}

	

</script>
        
</head>
<style type="text/css">
form
{
	float:left;
	
}
body{
	font-family: sans-serif;
	font-size: large;
	font-style: normal;
	font-variant: normal;
	color: #003366;

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
<body background="b.jpg" onload="myf()">

<% HttpSession ses=request.getSession(false);
//System.out.println(ses);
	String uname=(String)ses.getAttribute("sid");
	ArrayList<NotificationInfo> nlist = (ArrayList<NotificationInfo>)ses.getAttribute("notification");
	String roll=(String)ses.getAttribute("roll");
	if(uname==null){
	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	rd.forward(request,response);
	}
%>

<form>
	<%for(NotificationInfo ninfo:nlist)
{
%>
	<input type="hidden" name="heading" value="<%=ninfo.getHeading()%>" >
	<input type="hidden" name="message" value="<%=ninfo.getMessage()%>" >
	
	
<%} %>
</form>
<h2>Welcome <%=uname %></h2>
<br>

<div align="right"> <a href="LogoutServlet">Logout</a> </div>
<br>

<!--
<form action="ExamRequestServlet">
<input type="hidden" name="test" value="Entrance">  
<input type="submit" value="Give Test">
</form>
<br>
-->
<div align="left"><a href="StudentChangePassword.html">Change Password</a></div>
<br>
<form action="Notebook" method="get">
<input type="submit" value="E-notebook">
</form>&nbsp;&nbsp;
<form action="GetExam">
<input type="hidden" value=<%=uname %> name="uname">
<input type="submit" value="Pending Exams">
</form>&nbsp;&nbsp;
<form action="StudentGetAssignment">
<input type="submit" value="Assignments">
</form>&nbsp;&nbsp;
<form action="StudentViewMaterial">
<input type="submit" value="ViewMaterial">
</form>&nbsp;&nbsp;
<form action="ViewNotificationServlet">
<input type="submit" value="ViewNotification">
</form>
</body>
</html>