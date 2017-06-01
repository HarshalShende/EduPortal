package com.eduportal.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.BatchDao;
import com.eduportal.dao.StudentDao;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class ApproveStudentServlet
 */
@WebServlet("/ApproveStudentServlet")
public class ApproveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveStudentServlet() {
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
		List<String> idrollist=(ArrayList<String>) ses.getAttribute("idroll");
		String byr=(String)request.getParameter("byear");
		Date semstart=Date.valueOf(request.getParameter("semstart"));
		
		BatchDao bdao=new BatchDao();
		bdao.setBatch(byr, semstart);
		
		
		for(String idroll:idrollist)
		{
			System.out.println(idroll);
			String temp[]=idroll.split(" ");
			String id=temp[0];
			String roll=byr+temp[1];
			
			
			System.out.println(id);
			System.out.println(roll);
			
			
			StudentInfo sob;
			StudentDao sdao=new StudentDao();
			
			sob=sdao.listStudentInfo(id);
			sob.setId(roll);
			sob.setBatch(byr);
			
			sdao.insertRecord(sob, "approvedstudent");
			sdao.deleteRecord(id, "studentrec");
			
			
		}
		ses.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("/ViewApproval");
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
