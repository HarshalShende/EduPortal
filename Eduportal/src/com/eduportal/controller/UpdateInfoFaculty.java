package com.eduportal.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class UpdateInfoFaculty
 */
@WebServlet("/UpdateInfoFaculty")
public class UpdateInfoFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sname=request.getParameter("sname");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String dob=request.getParameter("dob");
		String paddr=request.getParameter("paddr");
		String phno=request.getParameter("phno");
		String mob=request.getParameter("mob");
		String email=request.getParameter("email");
		String permaddr=request.getParameter("permaddr");
		String roll=request.getParameter("roll");
		String subject=request.getParameter("subject");
		String college=request.getParameter("college");
		String qual=request.getParameter("qual");
		
		System.out.println("Roll="+roll);
		
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		
		try
		{
			
			con=(Connection) DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("update facultyrec set fname=?,"
					+ "uname=?, password=?,dob=?,presentaddr=?,phn=?,mob=?,email=?,permaddr=?,"
					+ "subject=?,qualification=?,college=? where fid=?");
			ps.setString(1,sname);
			ps.setString(2,uname);
			ps.setString(3,pwd);
			ps.setString(4,dob);
			ps.setString(5,paddr);
			ps.setString(6,phno);
			ps.setString(7,mob);
			ps.setString(8,email);
			ps.setString(9,permaddr);
			ps.setString(10,subject);
			ps.setString(11,qual);
			ps.setString(12,college);
			ps.setString(13, roll);
			int i=ps.executeUpdate();		
		}
		catch(Exception e)
		{			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("AdminHomepage.jsp");
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
