<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.eduportal.model.QuestionReportInfo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
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
<body background="b.jpg">

<% int score=(int)request.getAttribute("score"); 
	String test=(String) request.getAttribute("test");
	HttpSession ses=null;
	ses=request.getSession(false);
	String nextPage="";
	if(ses.getAttribute("type").equals("Reg"))
	{
		nextPage="Home.html";
		//ses.invalidate();
	}
	else
		nextPage="StudentHomepage.jsp";

%>
<img src="t.jpg">

<div align="right"> <a href=<%=nextPage %>>Back</a> </div>

<br>
<h2>Your score is <%=score %></h2>

<br><br>

<% ArrayList<QuestionReportInfo> qrl=(ArrayList<QuestionReportInfo>) ses.getAttribute("report");
	ses.removeAttribute("report");
%>
<table align="center" cellspacing="4">

<tr>
<th>Qno</th>
<th>Question</th>
<th>Your Answer</th>
<th>Correct Answer</th>
<th>Correct/Wrong</th>
</tr>

<% for(QuestionReportInfo qobj:qrl){ %>

<tr>
<td> <%= qobj.getQno() %> </td>
<td> <%=qobj.getQues() %></td>
<td> <%= qobj.getYourAns() %></td>
<td> <%= qobj.getCorrectAns() %></td>
<td> <% if(qobj.getCorrect()==1){ %>
<img alt="Correct" src="images/tick.png">
<%} 
else{%>
<img alt="Wrong" src="images/cross.png">
<%} %>

</td>
</tr>

<%} %>

</table>

<%
if(ses.getAttribute("type").equals("Reg"))
{
	ses.invalidate();
}

%>


</body>
</html>