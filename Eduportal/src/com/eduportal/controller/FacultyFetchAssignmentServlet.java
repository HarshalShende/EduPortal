package com.eduportal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.AssignmentDao;
import com.eduportal.model.AssignmentInfo;

/**
 * Servlet implementation class FacultyFetchAssignmentServlet
 */
@WebServlet("/FacultyFetchAssignmentServlet")
public class FacultyFetchAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyFetchAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession ses=request.getSession(false);
		String fid=(String)ses.getAttribute("froll");
		AssignmentDao adao=new AssignmentDao();
		ArrayList<AssignmentInfo> alist=adao.facultyGetAssignment(fid);
		request.setAttribute("alist", alist);
		RequestDispatcher rd=request.getRequestDispatcher("FacultyFetchAssignments.jsp");
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
