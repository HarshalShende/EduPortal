package com.eduportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.BatchDao;

/**
 * Servlet implementation class GetSemSubjectServlet
 */
@WebServlet("/GetSemSubjectServlet")
public class GetSemSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSemSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BatchDao bdao=new BatchDao();
		String batch=request.getParameter("batch");
		System.out.println("Batch="+batch);
		List<String> sublist=bdao.getSubjects(batch);
		
		PrintWriter out=response.getWriter();
		//write in xml format for ajax in FacultySetExam.jsp
		response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        
        for(String sub:sublist)
        {
        	out.println("<subject>"+sub+"</subject>");
        	System.out.println("Ajax "+sub);
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
