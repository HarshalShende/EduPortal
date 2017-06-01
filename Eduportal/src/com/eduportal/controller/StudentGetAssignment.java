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
import javax.servlet.http.HttpSession;

import com.eduportal.dao.AssignmentDao;
import com.eduportal.model.AssignmentInfo;
import com.eduportal.model.NotificationInfo;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class StudentGetAssignment
 */
@WebServlet("/StudentGetAssignment")
public class StudentGetAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentGetAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession ses=request.getSession();
		StudentInfo sobj=(StudentInfo)ses.getAttribute("sinfo");
		String batch=sobj.getBatch();
		List<AssignmentInfo> alist=new ArrayList<AssignmentInfo>();
		AssignmentDao adao=new AssignmentDao();
		alist=adao.getAssignments(batch);
		request.setAttribute("alist", alist);
		
		ArrayList<NotificationInfo> nlist=new ArrayList<NotificationInfo>();
		ses.setAttribute("notification",nlist);
		
		RequestDispatcher rd=request.getRequestDispatcher("StudentShowAssignments.jsp");
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
