<%@page import="org.jsoup.safety.Whitelist"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.examples.HtmlToPlainText"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style type="text/css" media="all">
	@import "css/info.css";
	@import "css/main.css";
	@import "css/widgEditor.css";
</style>

<script type="text/javascript" src="scripts/widgEditor.js"></script>


<script type="text/javascript" src="scripts/saveInFile.js"></script>


</head>
<body>
<p><b>            
                          
                &nbsp;-----------------E-NOTEBOOK---------------</b></p>
        
        <div id="content">
	<form action="SaveNotebook" method="post">
	 <%String s=request.getAttribute("name").toString()+"<hr>";
	 String date=request.getAttribute("date").toString();
	 s=s+"<b>"+date+"</b><hr><br>";
	 %>
	 <fieldset>
	 <textarea id="noise" name="noise" class="widgEditor nothing"><%=s %></textarea>
	</fieldset>
	
	<fieldset>
	<input type="submit" value="Save">
	<input type="button" value="Download" onclick="saveTextAsFile()">
	</fieldset>
	 </form>
	 <% HtmlToPlainText obj=new HtmlToPlainText();
	 String formatted= obj.getPlainText(Jsoup.parse(Jsoup.clean(s, Whitelist.basic().addTags("div","p"))));%>
	 <!-- <input type="hidden" value=<%=formatted %> id="textdata">	-->
	 <!-- <textarea id="textdata" style="visibility:hidden;position:absolute;" value=<%=formatted %>></textarea>
	 <br>
	 <div><%=formatted %></div>
	 <br>	-->
	 <button onclick="location.href='StudentHomepage.jsp';">BACK </button> 
	 </div>
</body>
</html>