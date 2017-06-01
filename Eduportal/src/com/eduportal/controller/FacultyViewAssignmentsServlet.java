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
import com.eduportal.dao.DBConnection;
import com.eduportal.model.AssignmentSubmissionInfo;

/**
 * Servlet implementation class FacultyViewAssignmentsServlet
 */
@WebServlet("/FacultyViewAssignmentsServlet")
public class FacultyViewAssignmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyViewAssignmentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AssignmentDao ad=new AssignmentDao();
		ArrayList<AssignmentSubmissionInfo> alist=new ArrayList<AssignmentSubmissionInfo>();
		HttpSession ses=request.getSession(false);
		String fid=(String)ses.getAttribute("froll");
		alist=ad.getAssignmentSubmission(fid);
		request.setAttribute("assinfo", alist);
		
		RequestDispatcher rd=request.getRequestDispatcher("FacultyViewAssignments.jsp");
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
