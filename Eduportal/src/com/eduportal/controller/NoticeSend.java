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
import com.eduportal.service.SendSms;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class NoticeSend
 */
@WebServlet("/NoticeSend")
public class NoticeSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String head=request.getParameter("heading");
		String batch=request.getParameter("batch");
		String message=request.getParameter("message");
		
		HttpSession ses=request.getSession(false);
		String teacher=(String)ses.getAttribute("fid");
		
		Connection con=null;
		PreparedStatement ps;
		ResultSet rs;
		int i;
		
		try
		{
			con=(Connection)DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("select sid from approvedstudent where batch=?");  
            ps.setString(1, batch);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
            	String sid=rs.getString(1);
            	ps=(PreparedStatement) con.prepareStatement("insert into unviewednotification values(?,?,?,?)");
            	ps.setString(1, head);
            	ps.setString(2, message);
            	ps.setString(3,teacher);
            	ps.setString(4, sid);
            	i=ps.executeUpdate();
            	System.out.println(i);
            	
            	ResultSet rsmsg;
            	ps=(PreparedStatement) con.prepareStatement("select mob from approvedstudent where sid=?;");
            	ps.setString(1, sid);
            	rsmsg=ps.executeQuery();
            	if(rsmsg.next())
            	{
            		SendSms sms=new SendSms();
            		sms.SMSSend(rsmsg.getString(1),head);
            	}
            }
            
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("FacultyHomepage.jsp");
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
