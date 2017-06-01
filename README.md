# EduPortal
A web based portal for an educational institute

Server Machine Installation Guide:

•	Install Apache tomcat (8.0.35) on the server machine.

•	Install JRE8.

•	Install MySql server and build the following tables:

  o	adminrec(uname varchar(50),password varchar(100))
  
  o	approvedstudent(sid varchar(20) primary key,sname varchar(50),uname varchar(30),password varchar(30),dob varchar(20),gender varchar(10),permAddr varchar(100),presentAddr varchar(100),phn varchar(15),mob(varchar(15),escore int,batch varchar(10),stream varchar(30))
  
  o	assignments(ano int primary key references setassignment(qno),sid varchar(20),fname varchar(50),fileloc varchar(200),dt varchar(20))
  
  o	attendance(sid varcahar(20) references approvedstudent(sid),sname varchar(50) references approvedstudent(sname),atd float)
  
  o	batch(bname varchar(20) primary key,semester varchar(15),nextupdatedate date)
  
  o	exam(subject varchar(30),noq int)
  
  o	examresult(eno int,batch varchar(20),sid varchar(20),subject varchar(50),result int)
  
  o	facultyrec(fid varchar(20) primary key,fname varchar(50),uname varchar(30),password varchar(30),dob varchar(20),gender varchar(10),permaddr varchar(100),presentaddr varchar(100),phn varchar(15),mob varchar(15),email varchar(50),subject varchar(30),qualification varchar(30),college varchar(50))
  
  o	material(mno int primary key auto_increment,bname varchar(20) references batch(bname),fileloc varchar(1000),fid varchar(20))
  
  o	notebook(sid varchar(20) references approvedstudent(sid),data blob)
  
  o	notice(id int primary key auto_increment,batch varchar(20) not null references batch(bname),msg varchar(10000),fileloc varchar(500))
  
  o	querymsg(name varchar(50),mailed varchar(100),message varchar(10000))
  
  o	question(qid int primary key auto_increment,weight int(1),semester varchar(15),subject varchar(30) references exam(subject),question varchar(200),op1 varchar(50),op2 varchar(50),op3 varchar(50),op4 varchar(50),answer int(1),noc int,tot int,percentage float,topic varchar(40))
  
  o	setassignment(qno int primary key,batch varchar(20) references batch(bname),question varchar(5000),solution varchar(1000),teacher varchar(50),subject varchar(50))
  
  o	setexamrecord(eno int,sid varchar(20),subject varchar(50) references exam(subject),expirydate date)
  
  o	studentrec(sid varchar(20) primary key,sname varchar(50),uname varchar(30),password varchar(30),dob varchar(20),gender varchar(10),permAddr varchar(100),presentAddr varchar(100),phn varchar(15),mob varchar(15),email varchar(50),escore int,batch varchar(10),stream varchar(100))
  
  o	subjects(scode varchar(10) primary key,sname varchar(50),semester varchar(15))
  
  o	temp(assno int default 1,examno int default 1)
  
  o	tempfaculty(fid varchar(20) primary key,fname varchar(50),uname varchar(30),password varchar(30),dob varchar(20),gender varchar(10),permaddr varchar(100),presentaddr varchar(100),phn varchar(15),mob varchar(15),email varchar(50),subject varchar(30),qualification varchar(30),college varchar(50))
  
  o	unviewednotification(heading varchar(30),message varchar(30),tag varchar(30),sid varchar(20))
  
  o	viewednotification(heading varchar(30),message varchar(30),tag varchar(30),sid varchar(20))
  
•	Import the project in the server machine and add it to the server.

•	Create folder “UploadedFile” in E:\ drive and subfolders “AssignmentSubmission”, “Attendance”, “Notice”, “Question”, “Temp” in E:\UploadedFile.


You must create an account in bulksms.com and put your username and password in services/SendSMS.java
