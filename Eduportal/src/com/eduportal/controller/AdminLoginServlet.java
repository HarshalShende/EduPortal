package com.eduportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.AdminDao;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		String id=request.getParameter("admid");
		String pass=request.getParameter("admpass");
		PrintWriter out=response.getWriter();
		AdminDao adao=new AdminDao();
		boolean f=adao.loginCheck(id, pass);
		if(f)
		{
			HttpSession ses=request.getSession(true);
			ses.setAttribute("type", "admin");
			RequestDispatcher rd=request.getRequestDispatcher("AdminHomepage.jsp");
			//request.setAttribute("token", 1);
			rd.forward(request, response);
		}
		else
		{
			//PrintWriter out=response.getWriter();
			out.println("<b>Invalid Username or password</b>");
		}
	}

}
