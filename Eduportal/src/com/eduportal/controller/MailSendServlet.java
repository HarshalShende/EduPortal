package com.eduportal.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*; 

/**
 * Servlet implementation class MailSendServlet
 */
@WebServlet("/MailSendServlet")
public class MailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String subject=(String)request.getParameter("subject");
		String msg=(String)request.getParameter("message");
		String password=(String)request.getParameter("pwd");
		String batch=(String)request.getParameter("batch");
		
		HttpSession ses=request.getSession(false);
		
		String uid=(String)ses.getAttribute("fid");
		
		
		System.out.println(uid);
		System.out.println(msg);
		
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		
		String from,to;
		
		try
		{
			con=(Connection)DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("select * from facultyrec where uname=?");  
            ps.setString(1, uid);
            rs=ps.executeQuery();
            rs.next();
            from=rs.getString(11);
            
            System.out.println("from email "+from);
            
            Properties props = new Properties();    
            props.put("mail.smtp.host", "smtp.gmail.com");    
            props.put("mail.smtp.socketFactory.port", "465");    
            props.put("mail.smtp.socketFactory.class",    
                      "javax.net.ssl.SSLSocketFactory");    
            props.put("mail.smtp.auth", "true");    
            props.put("mail.smtp.port", "465");    
            //get Session   
            Session session = Session.getDefaultInstance(props,    
             new javax.mail.Authenticator() {    
             protected PasswordAuthentication getPasswordAuthentication() {    
             return new PasswordAuthentication(from,password);  
             }    
            });    
            
            ps=(PreparedStatement) con.prepareStatement("select email from approvedstudent where batch=?");  
            ps.setString(1, batch);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
            	to=rs.getString(1);
            	System.out.println("to"+to);
            	
            	MimeMessage message = new MimeMessage(session);    
                message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
                message.setSubject(subject);    
                message.setText(msg);    
                //send message  
                Transport.send(message);   
                System.out.println("message sent successfully... to "+to);  
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("/FacultyHomepage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
