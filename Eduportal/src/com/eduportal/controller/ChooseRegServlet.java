package com.eduportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.SubjectDao;
import com.eduportal.model.SubjectInfo;

/**
 * Servlet implementation class ChooseRegServlet
 */
@WebServlet("/ChooseRegServlet")
public class ChooseRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String type=(String)request.getParameter("logtype");
		if(type.equals("Student"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("StudentReg.jsp");
			rd.forward(request, response);
		}
		else if(type.equals("Faculty"))
		{
			SubjectDao sdao=new SubjectDao();
			List<SubjectInfo> slist=new ArrayList<SubjectInfo>();
			slist=sdao.getSubjects();
			request.setAttribute("subjectlist", slist);
			
			RequestDispatcher rd=request.getRequestDispatcher("FacultyReg.jsp");
			rd.forward(request, response);
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
