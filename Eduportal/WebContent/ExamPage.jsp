<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.eduportal.model.QuestionLevelLists" %>
<%@ page import="com.eduportal.model.QuestionInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Page</title>





<script type="text/javascript">





var tim;

var min = 1;
var sec = 10;
var f = new Date();
function f1() {
    f2();
    document.getElementById("starttime").innerHTML = "Your started your Exam at " + f.getHours() + ":" + f.getMinutes();
     
  
}
function f2() {
    if (parseInt(sec) > 0) {
        sec = parseInt(sec) - 1;
        document.getElementById("showtime").innerHTML = "Your Left Time  is :"+min+" Minutes ," + sec+" Seconds";
        tim = setTimeout("f2()", 1000);
    }
    else {
        if (parseInt(sec) == 0) {
            min = parseInt(min) - 1;
            //document.getElementById("showtime").innerHTML = "Your Left Time  is :"+min+" Minutes ," + sec+" Seconds";
            
            if (parseInt(min) < 0) {
                clearTimeout(tim);
                //location.href = "";
                document.getElementById("ques").innerHTML="";
                document.getElementById("options").innerHTML="";
                
            }
            else {
                sec = 60;
                document.getElementById("showtime").innerHTML = "Your Left Time  is :" + min + " Minutes ," + sec + " Seconds";
                tim = setTimeout("f2()", 1000);
            }
        }
       
    }
}



</script>

<!--  
<script src="jQuery/jquery.min.js"></script>
<script src="jQuery/jquery-ui.min.js"></script>

  <script type="text/javascript">

       $(document).ready(function() 
       {
          function disableBack() { window.history.forward() }

          window.onload = disableBack();
          window.onpageshow = function(evt) 
                              { if (evt.persisted) disableBack() }
        });
</script>
-->


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

<body onload="f1()" >

<!-- 
<script src="jQuery/jquery.min.js"></script>
<script src="jQuery/jquery-ui.min.js"></script>

<script type="text/javascript">

       //$(document).ready(function() 
       //{
          function disableBack() { window.history.forward() }

          window.onload = disableBack();
          window.onpageshow = function(evt) 
                              { if (evt.persisted) disableBack() }
        //});
</script>

-->

<script type="text/javascript">

window.location.hash="no-back-button";
window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
window.onhashchange=function(){window.location.hash="no-back-button";}


</script>

    <form id="form1" runat="server">
    <div>
      <table width="100%" align="center">
        
        <tr>
          <td>
            <div id="starttime"></div><br />
            <div id="endtime"></div><br />
            <div id="showtime"></div>
          </td>
        </tr>
        <tr>
          <td>
             
              <br />
            
              
          </td>
         
        </tr>
      </table>
      <br />
   
 
    </div>
    </form>


<% QuestionInfo qob=(QuestionInfo)request.getAttribute("qlists");
	int level=(int)request.getAttribute("level");
	int n=(int)request.getAttribute("rno");
	int qnum=(int)request.getAttribute("qnum");
	int score=(int) request.getAttribute("score");
	String test=(String) request.getAttribute("test");
	/*Random rnd=new Random();
	int n=rnd.nextInt(4);*/
	String question=null;
	String op1=null;
	String op2=null;
	String op3=null;
	String op4=null;
	int ans=0;
	String serv="CheckExamServlet";
	
	/*if(test.equals("Entrance"))
		serv="CheckEntranceExam";
	else if(test.equals("Automata"))
		serv="CheckAutomataExam";
	else if(test.equals("Computer Architecture"))
		serv="CheckCArch";
	else if(test.equals("Computer Networking"))
		serv="CheckCNet";
	else if(test.equals("Computer Organization"))
		serv="CheckCOrg";
	else if(test.equals("Computer Programming"))
		serv="CheckCProg";
	else if(test.equals("DBMS"))
		serv="CheckDBMSExam";
	else if(test.equals("Entrance"))
		serv="CheckEntranceExam";
	else if(test.equals("Logical Reasoning"))
		serv="CheckLogicalExam";
	else if(test.equals("Quantitative Analysis"))
		serv="CheckQuantitativeExam";
	else if(test.equals("Verbal Ability"))
		serv="CheckVerbalExam";
	else
		System.out.println("Error in.... "+test);*/
	
	
	question=qob.getQues();
	op1=qob.getOp1();
	op2=qob.getOp2();
	op3=qob.getOp3();
	op4=qob.getOp4();
	ans=qob.getAns();

%>

<span><b>Q</b><b><%=qnum %></b><span style="float:right">Your Score: <b><%=score %></b></span></div>
<br><br><br>
<div id="ques" name="ques" align="center"><%=question %></div>
<br>
<br>
<form action=<%=serv %> method="post">
<table align="center" id="options">
<tr>
<th>A.&nbsp;</th>
<td><input type="radio" id="op" name="op" value=1><%=op1 %></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<th>B.&nbsp;</th>
<td><input type="radio" id="op" name="op" value=2><%=op2 %></td>
</tr>

<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>

<tr>
<th>C.&nbsp;</th>
<td><input type="radio" id="op" name="op" value=3><%=op3 %></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<th>D.&nbsp;</th>
<td><input type="radio" id="op" name="op" value=4><%=op4 %></td>
</tr>

</table>

<input type="hidden" id="qans" name="qans" value="<%=ans %>">
<input type="hidden" id="qlvl" name="qlvl" value="<%=level %>">
<input type="hidden" id="ran" name="ran" value="<%=n %>">
<input type="hidden" id="quesno" name="quesno" value="<%=qnum %>">
<input type="hidden" id="qscore" name="qscore" value="<%=score %>">
<input type="hidden" id="test" name="test" value="<%=test %>">

<input type="submit" value="Next Question">
<input type="reset" value="Clear Response">
</form>

</body>
</html>