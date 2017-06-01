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

import com.eduportal.dao.ExamDao;
import com.eduportal.dao.StudentDao;
import com.eduportal.model.ExamResultInfo;
import com.eduportal.model.NotificationInfo;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class GetExam
 */
@WebServlet("/GetExam")
public class GetExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetExam() {
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
		StudentInfo sob=(StudentInfo) ses.getAttribute("sinfo");
		ExamDao sdao=new ExamDao();
		List<ExamResultInfo> elist=new ArrayList<ExamResultInfo>();
		elist=sdao.getExam(sob.getId());
		request.setAttribute("examlist", elist);
		
		ArrayList<NotificationInfo> nlist=new ArrayList<NotificationInfo>();
		ses.setAttribute("notification",nlist);
		RequestDispatcher rd=request.getRequestDispatcher("StudentExamShow.jsp");
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
