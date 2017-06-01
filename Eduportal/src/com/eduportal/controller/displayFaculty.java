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
import com.eduportal.model.FacultyInfo;
import com.eduportal.model.StudentInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class displayFaculty
 */
@WebServlet("/displayFaculty")
public class displayFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		
		String roll =(String) request.getParameter("roll");
		FacultyInfo fobj=new FacultyInfo();
		
		
		response.setContentType("text/html");
		try
		{
			
			con=(Connection) DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("select * from facultyrec where fid=?");
					
			ps.setString(1, roll);
			ResultSet rs=ps.executeQuery();	
			rs.next();
			
			fobj.setFname(rs.getString(2));
			fobj.setUname(rs.getString(3));
			fobj.setPass(rs.getString(4));
			fobj.setDob(rs.getString(5));
			fobj.setGender(rs.getString(6));
			fobj.setPermaddr(rs.getString(7));
			fobj.setPresentaddr(rs.getString(8));
			fobj.setResPh(rs.getString(9));
			fobj.setMob(rs.getString(10));
			fobj.setEmail(rs.getString(11));
			fobj.setSubject(rs.getString(12));
			fobj.setQual(rs.getString(13));
			fobj.setCollege(rs.getString(14));
			fobj.setId(roll);
		}
		catch(Exception e)
		{
			
		}
		request.setAttribute("info", fobj);
		RequestDispatcher rd=request.getRequestDispatcher("AdminShowFacultyDetails.jsp");
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
