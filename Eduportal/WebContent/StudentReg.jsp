<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
<script type="text/javascript">

var check = function() {
	  if (document.getElementById('spass').value ==
	    document.getElementById('srepass').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
		  document.getElementById("Button").disabled = false;
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	    
	    document.getElementById("Button").disabled = true;
	  }
	}
	
function getXMLObject()  //XML OBJECT
{
   var xmlHttp = false;
               
   try 
   {
      xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  // For Old Microsoft Browsers
   }catch (e)
    {
       try 
       {
          xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");  // For Microsoft IE 6.0+
       }catch (e2) { xmlHttp = false;   /* No Browser accepts the XMLHTTP Object then false */  }
    }

    if (!xmlHttp && typeof XMLHttpRequest != 'undefined') 
    {
        xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
    }
    return xmlHttp;  // Mandatory Statement returning the ajax object created
}

var xmlhttp = new getXMLObject();	//xmlhttp holds the ajax object

function ajaxFunction() 
{
	 if(xmlhttp.readyState == 0 || xmlhttp.readyState == 4 )        
    {
   	var uid = document.getElementById("suname").value;
   	//alert(uid);
   	
       xmlhttp.open("GET","CheckUsernameAvailabilityServlet?data="+uid, true);
       xmlhttp.onreadystatechange  = handleServerResponse;
         //  xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
       xmlhttp.send(null);//disconnect server
    }
}

function handleServerResponse() 
{
	 
   if (xmlhttp.readyState == 4) 
   {
       if(xmlhttp.status == 200) 
       {
       	var xmlMessage= xmlhttp.responseXML;
       	var valid=xmlMessage.getElementsByTagName("valid")[0].firstChild.nodeValue;
       	
       	if(valid=="true")
       	{
       		var validationMessage=document.getElementById("validationMessage");
       		validationMessage.innerHTML = "";
       		//document.getElementById("submitForm").disabled = false;
           }
       	
       	if(valid=="false")
       	{
       		var validationMessage=document.getElementById("validationMessage");
       		validationMessage.innerHTML = "Username already exists";
       		document.getElementById("suname").value="";
       		//document.getElementById("submitForm").disabled = true;
       	}
       }
       else 
       {
            alert("Error during AJAX call. Please try again");
       }
   }
}

</script>
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
<body background="b.jpg" >
	<%
	Random r=new Random();
	int x=r.nextInt(1000000);
	String id="S"+x;

	%>

<h2>Student Registration</h2>
	<form action="StudentRegServlet" name="myForm" method="post">
	
	<div align="center">
	
	<input type="hidden" name="eno" value=0>
	Id &nbsp; &nbsp;
	
	<input type="text" id="id" name="id" readonly="readonly" value="<%=id %>">
	</div>
	<hr>
	
	<h4>Personal Details</h4><br/>
	<table align="center">
	<tr>
	<td>
	First Name 
	</td>
	<td>
	<input type="text" id="sfname" name="sfname" required>
	</td>
	</tr>
	
	<tr>
	<td>
	Last Name 
	</td>
	<td>
	<input type="text" id="slname" name="slname" required>
	</td>
	</tr>
	
	<tr>
	<td>Username</td>
	<td> <input type="text" id="suname" name="suname" onblur="ajaxFunction()" required></td>
	<td><div id="validationMessage"></div></td>
	</tr>
	
	<tr>
	<td>Password</td>
	<td> <input type="password" id="spass" name="spass" onkeyup='check();' required/></td>
	</tr>
	
	<tr>
	<td>Re-enter Password</td>
	<td> <input type="password" id="srepass" name="srepass" onkeyup='check();' required/></td>
	<td><span id='message'></span></td>
	</tr>
	
	<br>
	<tr>
	<td>Date of Birth </td>
	<td><input type="date" id="stdob" name="stdob" required></td>
	</tr>
	<br/>
	</table>
	
	<table align="center">
	<tr>
	<td>Gender </td>
	<td> <input type="radio" id="stgender" name="stgender" value="Male">Male</td>
	<td> <input type="radio" id="stgender" name="stgender"value="Female">Female</td>
	<td> <input type="radio" id="stgender" name="stgender"value="Other">Other</td>
	</tr>
	<br/>

	</table>
	<hr>
    
    <h4>Communication Details</h4>
	<br/>
	
	<table align="center">
	<tr>
	<td>Permanent Address</td>
	<td><input type="text" id="stpermanentaddr" name="stpermanentaddr">
	</td>
	</tr>
	
	<tr>
	<td>Present Address</td>
	<td><input type="text" id="stpresentaddr" name="stpresentaddr">
	</td>
	</tr>
	
	<tr>
	<td>Phone(Res)</td>
	<td><input type="text" id="stresph" name="stresph"></td>
	</tr>
	
	<tr>
	<td>Mobile</td>
	<td><input type="text" id="stmob" name="stmob" size=10 required>
	</td>
	<td>&nbsp;&nbsp;
	<div></div>
	</tr>
	
	<tr>
	<td>Email</td>
	<td><input type="email" id="stemail" name="stemail" size=10 required>
	</td>
	<td>&nbsp;&nbsp;
	<div></div>
	</tr>
	
	</table>
    
	<tr>
	<td>Stream</td>
	<td>
	
	<!-- 
	<select id="ststream" name="ststream">
	<option>Applied Electronics & Instrumentation Engineering</option>
	<option>Civil Engineering</option>
	<option>Computer Science and Engineering</option>
	<option>Electrical Engineering</option>
	<option>Electronics & Communication Engineering</option>
	<option>Food Technology</option>
	<option>Information Technology</option>
	<option>Mechanical Engineering</option>
	<option>Other</option>
	</select>
	-->
	
	<input type="hidden" name="sttream">

	</td>
	</tr>
	</table>
	<br/>
	<br>
	
	<input type="submit" value="Submit and Proceed to Entrance Test" id="Button">
	<input type="reset" value="Clear">
	
	
	</form>
	

</body>
</html>