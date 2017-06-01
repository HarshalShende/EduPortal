package com.eduportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.DBConnection;
import com.eduportal.model.StudentInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class displayServlet
 */
@WebServlet("/displayServlet")
public class displayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con=null;
		PreparedStatement ps=null;
		
		String roll =(String) request.getParameter("roll");
		StudentInfo sobj=new StudentInfo();
		
		response.setContentType("text/html");
		
		System.out.println(roll);
		try
		{
			
			con=(Connection) DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("select * from approvedstudent where sid=?");
					
			ps.setString(1, roll);
			ResultSet rs=ps.executeQuery();	
			rs.next();
			//if(rs.next())
			//{
			sobj.setId(rs.getString(1));
			sobj.setFname(rs.getString(2));
			sobj.setUname(rs.getString(3));
			sobj.setDob(rs.getString(5));
			sobj.setPass(rs.getString(4));
			sobj.setPermaddr(rs.getString(7));
			sobj.setPresentaddr(rs.getString(8));
			sobj.setResPh(rs.getString(9));
			sobj.setMob(rs.getString(10));
			sobj.setEmail(rs.getString(11));
			
			//}
			System.out.println(rs.getString(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("info", sobj);
		RequestDispatcher rd=request.getRequestDispatcher("AdminShowDetails.jsp");
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
