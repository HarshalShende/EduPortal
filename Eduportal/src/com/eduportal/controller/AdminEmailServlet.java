package com.eduportal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.service.SendEmail;

/**
 * Servlet implementation class AdminEmailServlet
 */
@WebServlet("/AdminEmailServlet")
public class AdminEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pass=request.getParameter("mailpass");
		//String senderId="rongangs95@gmail.com";
		String recvId=request.getParameter("recvid");
		String msg=request.getParameter("message");
		SendEmail eobj=new SendEmail();
		eobj.sendEmail(pass, recvId, msg);
		response.sendRedirect("AdminHomepage.jsp");
	}

}
