package com.eduportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.FacultyDao;
import com.eduportal.dao.StudentDao;

/**
 * Servlet implementation class CheckFacultyUsernameAvailabilityServlet
 */
@WebServlet("/CheckFacultyUsernameAvailabilityServlet")
public class CheckFacultyUsernameAvailabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckFacultyUsernameAvailabilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname=request.getParameter("data");
		FacultyDao sdao=new FacultyDao();
		boolean check=sdao.checkUsername(uname);
		PrintWriter out = response.getWriter();
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        if(check)
        {
        	out.println("<student>" + 
                    "<valid>false</valid>" +
			      "</student>"
                );
        }
        else
        {
        	out.println("<valid>true</valid>");
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
