package com.eduportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.FacultyDao;
import com.eduportal.dao.StudentDao;
import com.eduportal.model.FacultyInfo;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class ApproveReject
 */
@WebServlet("/ApproveReject")
public class ApproveReject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveReject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String type=request.getParameter("type");
		String roll=request.getParameter("roll");
		System.out.println(roll);
		if(type.equals("student"))
		{
		StudentInfo sob;
		StudentDao sdao=new StudentDao();
		if(request.getParameter("approve")!=null)
		{
			sob=sdao.listStudentInfo(roll);
			
			sdao.insertRecord(sob, "approvedstudent");
			sdao.deleteRecord(roll, "studentrec");
		}
		else if(request.getParameter("reject")!=null)
		{
			sdao.deleteRecord(roll, "studentrec");
		}
		}
		
		else if(type.equals("faculty"))
		{
			FacultyInfo fob;
			FacultyDao fdao=new FacultyDao();
			if(request.getParameter("approve")!=null)
			{
				fob=fdao.listFacultyInfo(roll);
				
				fdao.insertRecord(fob, "facultyrec");
				fdao.deleteRecord(roll, "tempfaculty");
			}
			else if(request.getParameter("reject")!=null)
			{
				fdao.deleteRecord(roll, "tempfaculty");
			}
			RequestDispatcher rd=request.getRequestDispatcher("/ViewApprovalFaculty");
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
