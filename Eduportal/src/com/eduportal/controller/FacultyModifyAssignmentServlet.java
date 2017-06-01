package com.eduportal.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.AssignmentDao;
import com.eduportal.model.AssignmentInfo;

/**
 * Servlet implementation class FacultyModifyAssignmentServlet
 */
@WebServlet("/FacultyModifyAssignmentServlet")
public class FacultyModifyAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyModifyAssignmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int ano=Integer.parseInt(request.getParameter("ano"));
		String batch=request.getParameter("batch");
		String ques=request.getParameter("ques");
		String sub=request.getParameter("sub");
		Date edt=Date.valueOf(request.getParameter("edt"));
		
		AssignmentInfo aobj=new AssignmentInfo();
		aobj.setQno(ano);
		aobj.setBatch(batch);
		aobj.setQuestion(ques);
		aobj.setSubject(sub);
		aobj.setEdate(edt);
		
		AssignmentDao adao=new AssignmentDao();
		adao.modifyAssignment(aobj);
		
		RequestDispatcher rd=request.getRequestDispatcher("FacultyHomepage.jsp");
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
