<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*" %>
<%@ page import="com.eduportal.model.BatchInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

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
   	var batch = document.getElementById("batch").value;
   	xmlhttp.open("GET","GetSemSubjectServlet?batch="+batch, true);
    xmlhttp.onreadystatechange  = handleServerResponse;
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
       	var sub=document.getElementById("subject");
       	sub.innerHTML="";
       	for(i=0;i<xmlMessage.getElementsByTagName("subject").length;i++)
       		{
       		//var valid=xmlMessage.getElementsByTagName("subject")[0].firstChild.nodeValue;
       		
       		sub.innerHTML+="<option>"+xmlMessage.getElementsByTagName("subject")[i].firstChild.nodeValue+"</option>";
       		System.out.println(xmlMessage.getElementsByTagName("subject")[i].firstChild.nodeValue);
       		}
       	
       }
       else
    	   {
    	   alert("Error During Ajax call.");
    	   }
   }
   else
	   {
	   alert("Problem");
	   }
}


</script>


</head>
<body background="b.jpg">

<br>
<h1>SET EXAM FOR PARTICULAR BATCH</h1>
<br><br>
<% ArrayList<BatchInfo> blist=(ArrayList<BatchInfo>)request.getAttribute("batchlist"); %>


<form action="FacultyGetSubject">
<b>Enter Batch </b>&nbsp;
<select name="batch" id="batch">


<%
for(BatchInfo bobj:blist)
{

%>
<option><%=bobj.getBname() %></option>

<%} %>

</select>

<!-- <br><br>
<select name="subject" id="subject">


</select>

<br><br>

Last Date of exam:&nbsp;
<input type="date" name="lastdt">
-->
<br><br>
<input type="submit" value="Get Subjects">
</form>


</body>
</html>