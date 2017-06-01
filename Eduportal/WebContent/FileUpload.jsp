<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>



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
        	var tname = document.getElementById("teacher").value;
        	//alert(uid);
        	if(tname=="Select one")
        		{
        			document.getElementById("tnameError").innerHTML="Please select a teacher"
        		}
        	else{
        		document.getElementById("tnameError").innerHTML="";
	            xmlhttp.open("GET","StoreTeacherInSession?data="+tname, true);
	            //xmlhttp.onreadystatechange  = handleServerResponse;
	              //  xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	            xmlhttp.send(null);//disconnect server
        	}
         }
     }
     
     </script>
	
</head>
<body bgcolor="#5fca90">

  <% ArrayList<String> flist=(ArrayList<String>)request.getAttribute("teachers"); %>
  <br/>
  <p align="center">
     <font  color="brown" size = "6">
     UPLOAD YOUR FILE &nbsp;&nbsp;&nbsp;
     </font>  
 </p>
  <br />
  
  <br />
  <hr>
  <div align="center">
   <div style="background-color: #5fca90; width: 450px;">
   <select name="teacher" id="teacher" onblur="ajaxFunction()">
   <option>Select one</option>
    <%for(String tname:flist)
    	{%>
    	<option><%=tname %></option>
    	<%} %>
    
    </select>
    &nbsp;&nbsp;
    <div id="tnameError" style="color:RED"></div>
 <form action="UploadDownloadFileServlet" method="post" enctype="multipart/form-data">
    <div style="color: #003366; font-weight: bold;font-size: 22px;">
       
    <br/>
    Select File to Upload:</div>
    <br/>
    <div style="color: #003366; font-size: 18px;" >
    <input type="file" name="fileName" class="button">
    </div>
<br>
	<input type="submit" value="Upload" class="button">
</form>
</div>
</div>
<br />
 <button onclick="location.href='StudentHomepage.jsp';">BACK </button> 

</body>
</html>