package com.eduportal.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.ExamDao;

/**
 * Servlet implementation class FacultyModifyExamDate
 */
@WebServlet("/FacultyModifyExamDate")
public class FacultyModifyExamDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyModifyExamDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int eno=Integer.parseInt(request.getParameter("eno"));
		String sub=request.getParameter("sub");
		Date edate=Date.valueOf(request.getParameter("edate"));
		ExamDao edao=new ExamDao();
		edao.modifyExamDate(eno,edate);
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
