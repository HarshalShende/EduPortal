package com.eduportal.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.FacultyDao;
import com.eduportal.dao.FileUploadDownloadDao;

/**
 * Servlet implementation class SetAssignmentServlet
 */
@WebServlet("/SetAssignmentServlet")
public class SetAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String batch=request.getParameter("batch");
		String ques=request.getParameter("question");
		String subject=request.getParameter("sub");
		Date edt=Date.valueOf(request.getParameter("expdate"));
		
		HttpSession ses=request.getSession(false);
		String froll=(String)ses.getAttribute("froll");
		
		
		FileUploadDownloadDao fdao=new FileUploadDownloadDao();
		int assno=fdao.setAssignment(batch, ques,froll,subject,edt);
		RequestDispatcher rd=request.getRequestDispatcher("FacultyHomepage.jsp");
		//HttpSession ses=request.getSession(false);
		ses.setAttribute("qno", assno);
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
