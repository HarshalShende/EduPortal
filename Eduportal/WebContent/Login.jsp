<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<jsp:include page="header.jsp"/>

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



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in</title>



<script type="text/javascript">
function gettype()
{
	var type=document.getElementsByName("logtype")
	for(i=0;i<type.length;i++)
		{
		if(type[i].checked)
			{
			document.getElementById("nextServlet").href="ChooseRegServlet?logtype="+type[i].value;
			break;
			}
		}
	
	}

</script>

<script src="jQuery/jquery.min.js"></script>
<script src="jQuery/jquery-ui.min.js"></script>

<script>
       
function disableBackButton() 
	       {
	          function disableBack() { window.history.forward() }

	          window.onload = disableBack();
	          window.onpageshow = function(evt) 
	                              { if (evt.persisted) disableBack() }
	        }

          
        
</script>

<script type="text/javascript">

function callDisableBack()
{
	var state=document.getElementById("state").value;
	if(state==="logout")
		disableBackButton();
	}

</script>

</head>

<body  background="b.jpg"  onload="gettype()" >

<%String state=(String)request.getAttribute("state"); %>

<input type="hidden" id="state" value=<%=state %>>
<br>
<div align="left"> <a href="Home.html"  style="color: #003366"><img src="logo.png" width="50" height="50"/>Home</a> </div>

<br>

<form action="LoginServelet" method="post"  >

	<input type="radio" name="logtype" id="logst" value="Student" checked="checked" onclick="gettype()">Student
	&nbsp;&nbsp;&nbsp;
	<input type="radio" name="logtype" id="logfac" value="Faculty" onclick="gettype()">Faculty<br>
	<br>
    <b>USER ID		</b> <input type="text" name="userid" ><br><br>
     <b>PASSWORD	</b> <input type="password" name="password"><br><br>
    
      <input type="submit" value="LOGIN">
      <br>
      <br>
      

      New User? &nbsp;&nbsp;&nbsp;

    <a id="nextServlet" style="color: #003366">Sign up</a>
    
      
 </form>
</body>
</html>