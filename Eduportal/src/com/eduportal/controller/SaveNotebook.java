package com.eduportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.DBConnection;
import com.eduportal.dao.StudentDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class SaveNotebook
 */
@WebServlet("/SaveNotebook")
public class SaveNotebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNotebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Connection con=null;
		PreparedStatement ps=null;
		String st=request.getParameter("noise");
		
		HttpSession ses=request.getSession(false);
		String sd=(String) ses.getAttribute("roll");
		System.out.println("save servlet");
		System.out.println(sd);
		try
		{
			con=(Connection) DBConnection.getMySQlConnection();
			PreparedStatement pst=(PreparedStatement) con.prepareStatement("delete from notebook where sid=?;");
			pst.setString(1,sd);
            int rs=pst.executeUpdate();
            System.out.println(rs);
            ps=(PreparedStatement) con.prepareStatement("insert into notebook values(?,?);");  
            ps.setString(1,sd); 
            ps.setString(2, st);
            int i=ps.executeUpdate();  
            System.out.println(i+" records affected"); 
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/StudentHomepage.jsp");
        rd.forward(request, response);
	}

}
