<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    	 //alert("inside ajax");
    	 if(xmlhttp.readyState == 0 || xmlhttp.readyState == 4 )        
         {
    		 //alert("inside ajax");
        	var batch = document.getElementById("batch").value;
        	//alert(batch);
        	//alert(uid);
        	
            xmlhttp.open("GET","GetSemSubjectServlet?batch="+batch, true);
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
    		   //alert("Problem");
    		   }
    	 }
</script>


</head>
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

<body background="b.jpg">

<form action="SetAssignmentServlet" method="get">

Batch:&nbsp;<input type="text" name="batch" id="batch" onblur="ajaxFunction()">
<br>
Subject:&nbsp;
<select id="subject" name="sub">

</select>
<br>
Problem Statement:<br>
<textarea rows="10" cols="30" name="question"></textarea>
<br/><br/>

Last Date Of Submission:
<input type="date" name="expdate"> <br>  <br>
<input type="submit">

</form>

</body>
</html>