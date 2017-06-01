<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    	 //alert('AA gya mai');
    	 if(xmlhttp.readyState == 0 || xmlhttp.readyState == 4 )        
         {
        	var bname = document.getElementById("bname").value;
        	//alert(bname);
        	//alert(uid);
        	/*if(tname=="Select one")
        		{
        			document.getElementById("tnameError").innerHTML="Please select a teacher"
        		}
        	else{*/
        		//document.getElementById("tnameError").innerHTML="";
	            xmlhttp.open("GET","StoreBatchForMaterialServlet?bname="+bname, true);
	            //xmlhttp.onreadystatechange  = handleServerResponse;
	              //  xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	            xmlhttp.send(null);//disconnect server
        	//}
         }
    	 else
    		 {
    		 alert('Problem');
    		 }
     }
     
     </script>


</head>
<body background="b.jpg">

<% HttpSession ses=request.getSession(false);
	String fid=(String)ses.getAttribute("fid");
	// ses.setAttribute("mno", mno);
%>

Enter Batch :<input type="text" name="bname" id="bname" onchange="ajaxFunction()">
<form action="FacultyUploadMaterial" method="post" enctype="multipart/form-data">

<br>
<input type="file" name="material">
<br><br>
<input type="submit" value="Upload">


</form>
</body>
</html>