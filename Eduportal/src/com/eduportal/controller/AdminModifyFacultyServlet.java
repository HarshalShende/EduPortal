package com.eduportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class AdminModifyFacultyServlet
 */
@WebServlet("/AdminModifyFacultyServlet")
public class AdminModifyFacultyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminModifyFacultyServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String s;
		
		try
		{
			
			con=(Connection) DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("select * from facultyrec");
			ResultSet rs=ps.executeQuery();		
			
			
			
			out.println("<html><body background='b.jpg'>");
			out.println("<table border='2' style='width:100%' >");
			
			out.println("<tr>");	
			out.println("<th>Fid</th><th>Faculty Name</th>"
					+ "<th>User Name</th><th>Password</th><th>Date Of Birth</th>"
					+ "<th>Gender</th><th>Permanent address</th><th> Present address</th>"
					+ "<th>Residential Phone</th><th>Mobile</th><th>Email</th>"
					+ "<th>Subject</th><th>Qualification</th><th>College</th>");
			
			out.println("</td>");
			out.println("</tr>");
			
			while(rs.next())
			{
				
				out.println("<tr>");	
				out.println("<td>");
				out.println("<a href='displayFaculty?roll="+rs.getString(1)+"'>");
				out.println(rs.getString(1));
				out.println("</a>");
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(2));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(3));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(4));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(5));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(6));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(7));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(8));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(9));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(10));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(11));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(12));

				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(13));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(14));
				out.println("</td>");
				
				out.println("</tr>");
				//i++;
				
			}
			out.println("</table>");
			
			//out.println("<form action=\"ModStu\">");
			//out.println("<input type=\"submit\">");
			//out.println("</form>");
			out.println("</body></html>");
			
		}
		catch(Exception e){	
			
		}
		
		out.println("<a href='AdminHomepage.jsp'>Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
