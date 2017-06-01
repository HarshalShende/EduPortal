<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*" %>
<%@page import="com.eduportal.model.StudentInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Pending Requests</title>
<script type="text/javascript">
function setvalue(val)
{
	document.getElementById("ht"+val).value=val;
}

function getyr()
{
	var yr=document.getElementById("byear").value;
	return yr;
}

function checkYr()
{
	var yr=document.getElementById("byear").value;
	if(yr===""||yr===null)
		{
		alert("Please enter a batch year.");
		return false;
		}
	return true;

}
</script>
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

<%! List<String> slist;
	String nextPage;
	
%>

<% List<StudentInfo> slist=(ArrayList<StudentInfo>) request.getAttribute("sids");
	//String nextPage=(String) request.getAttribute("next");
	nextPage="ViewStDetails";
	List<String> idroll=new ArrayList<String>();
%>



	<form action="ApproveStudentServlet" method="get" onsubmit="checkYr()">
	
	Batch Year &nbsp;&nbsp;
	<input type="text" id="byear" name="byear">
	<br><br>
	Semester start date:&nbsp;
	<input type="date" name="semstart">
	
	<table>
	
	
	<% for(int i=0;i<slist.size();i++)
		{
		StudentInfo str=slist.get(i);
		int j=i+1;
		String roll="";
		String tempir=str.getId()+" ";
		%>
	
	<tr>
	
	<td><%= str.getId() %></td><td><%=str.getName() %></td>
	<td><%=str.getEscore() %></td>
	<%if(i<15){  roll="E15-"+j; }
	else
		roll="GR-"+j;
	tempir=tempir+roll;
	idroll.add(tempir);
	
	%>
	 
	
	
	<td><%=roll %></td>
	<th><a href="<%= nextPage %>?st=<%=str.getId()%>&rollno=<%=roll %>">VIEW DETAILS</a></th> 
	
	</tr>
	<%} %>
	
	</table>
	<%HttpSession ses=request.getSession(true);
	ses.setAttribute("idroll", idroll);
	
	%>
	
	<input type="submit" value="Allot all students">
	</form>
	<br>
<a href="AdminHomepage.jsp">HOME</a>
</body>
</html>