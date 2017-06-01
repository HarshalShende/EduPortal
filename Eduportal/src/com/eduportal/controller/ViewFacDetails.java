package com.eduportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.FacultyDao;
import com.eduportal.model.FacultyInfo;

/**
 * Servlet implementation class ViewFacDetails
 */
@WebServlet("/ViewFacDetails")
public class ViewFacDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFacDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String fid=request.getParameter("st");
		FacultyDao fdao=new FacultyDao();
		FacultyInfo fob=new FacultyInfo();
		fob=fdao.listFacultyInfo(fid);
		
		RequestDispatcher rd=request.getRequestDispatcher("ApproveFacultyPage.jsp");
		request.setAttribute("finfo",fob);
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
