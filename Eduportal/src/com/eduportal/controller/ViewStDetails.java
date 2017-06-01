package com.eduportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.StudentDao;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class ViewStDetails
 */
@WebServlet("/ViewStDetails")
public class ViewStDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String sid=request.getParameter("st");
		String roll=request.getParameter("rollno");
		System.out.println(roll);
		System.out.println(sid);
		StudentDao sdao=new StudentDao();
		StudentInfo sob;
		sob=sdao.listStudentInfo(sid);
		
		RequestDispatcher rd=request.getRequestDispatcher("RejectPage.jsp");
		request.setAttribute("sinfo", sob);
		request.setAttribute("rollno", roll);
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
