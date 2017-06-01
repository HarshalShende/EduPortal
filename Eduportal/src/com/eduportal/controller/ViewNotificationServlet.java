package com.eduportal.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.DBConnection;
import com.eduportal.model.NotificationInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ViewNotificationServlet
 */
@WebServlet("/ViewNotificationServlet")
public class ViewNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewNotificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		
		HttpSession ses=request.getSession(false);
		String sid=(String)ses.getAttribute("roll");
		ArrayList<NotificationInfo> nlist=new ArrayList<NotificationInfo>();
		
		System.out.println(sid);
		try
		{
			con=(Connection)DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("select * from viewednotification where sid=?");  
            ps.setString(1, sid);
            rs=ps.executeQuery();
             
            while(rs.next())
            {
            	NotificationInfo ninfo=new NotificationInfo();
            	ninfo.setHeading(rs.getString(1));
            	ninfo.setMessage(rs.getString(2));
            	ninfo.setTag(rs.getString(3));
            	ninfo.setRoll(rs.getString(4));
            	
            	nlist.add(ninfo);        	
            }
            
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		request.setAttribute("notification", nlist);
		nlist=new ArrayList<NotificationInfo>();
		ses.setAttribute("notification",nlist);
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewNotification.jsp");
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
