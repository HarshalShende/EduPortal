package com.eduportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.FacultyDao;
import com.eduportal.dao.StudentDao;
import com.eduportal.model.NotificationInfo;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String logtype=request.getParameter("logtype");
		String uid=request.getParameter("userid");
		String pass=request.getParameter("password");
		//HttpSession ses=request.getSession(true);
		
		if(logtype.equals("Student"))
		{
		StudentDao stdao=new StudentDao();
		boolean f=stdao.loginCheck(uid, pass);
		String roll=stdao.getRoll(uid);
		PrintWriter out=response.getWriter();
		/*if(f)
		{
			out.println("<b>Student Homepage</b>");
		}
		else
			out.println("<b>Invalid Username or password</b>");*/
		if(f)
		{
			HttpSession ses=request.getSession(true);
			
			ArrayList<NotificationInfo> nlist;
			
			nlist=stdao.getnoti(roll);
			ses.setAttribute("sid", uid);
			ses.setAttribute("type", "Log");
			ses.setAttribute("notification", nlist);
			ses.setAttribute("roll", roll);
			request.setAttribute("state", "login");
			StudentInfo sobj=stdao.listStudentInfoFromUname(uid);
			ses.setAttribute("sinfo", sobj);
			RequestDispatcher rd=request.getRequestDispatcher("StudentHomepage.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("<b>Invalid Username or password</b>");
			
		}
		}
		
		else if(logtype.equals("Faculty"))
		{
			FacultyDao fdao=new FacultyDao();
			boolean f=fdao.loginCheck(uid, pass);
			PrintWriter out=response.getWriter();
			if(f)
			{
				String fname=fdao.getFnameFromUname(uid);
				String nameid[]=fname.split("/");
				HttpSession ses=request.getSession(true);
				ses.setAttribute("fid", uid);
				ses.setAttribute("fname", nameid[0]);
				ses.setAttribute("froll", nameid[1]);
				request.setAttribute("state", "login");
				RequestDispatcher rd=request.getRequestDispatcher("FacultyHomepage.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.println("<b>Invalid Username or password</b>");
				
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
