package com.eduportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.AdminDao;
import com.eduportal.dao.StudentDao;

/**
 * Servlet implementation class StudentChangePasswordServlet
 */
@WebServlet("/StudentChangePasswordServlet")
public class StudentChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentChangePasswordServlet() {
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
		String oldp=request.getParameter("oldpass");
		String newp=request.getParameter("newpass");
		HttpSession ses=request.getSession(false);
		String sid=(String)ses.getAttribute("roll");
		System.out.println(sid);
		StudentDao sdao=new StudentDao();
		boolean flag=sdao.changePassword(oldp,newp,sid);
		PrintWriter out=response.getWriter();
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Password Changed');");
			out.println("location='StudentHomepage.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Incorrect old password');");
			out.println("location='StudentChangePassword.html';");
			out.println("</script>");
		}
	

	}

}
