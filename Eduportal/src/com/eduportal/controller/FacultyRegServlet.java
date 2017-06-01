package com.eduportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.FacultyDao;
import com.eduportal.model.FacultyInfo;


/**
 * Servlet implementation class FacultyRegServlet
 */
@WebServlet("/FacultyRegServlet")
public class FacultyRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		FacultyInfo sob=new FacultyInfo();
		sob.setId(request.getParameter("id"));
		sob.setFname(request.getParameter("ffname"));
		sob.setLname(request.getParameter("flname"));
		sob.setUname(request.getParameter("funame"));
		sob.setPass(request.getParameter("fpass"));
		sob.setDob(request.getParameter("fdob"));
		sob.setGender(request.getParameter("fgender"));
		sob.setPermaddr(request.getParameter("fpermanentaddr"));
		sob.setPresentaddr(request.getParameter("fpresentaddr"));
		sob.setResPh(request.getParameter("fresph"));
		sob.setMob(request.getParameter("fmob"));
		sob.setEmail(request.getParameter("femail"));
		sob.setSubject(request.getParameter("fsub"));
		sob.setQual(request.getParameter("fqual"));
		sob.setCollege(request.getParameter("fcollege"));
		
		
		FacultyDao sdao=new FacultyDao();
		sdao.insertRecord(sob,"tempfaculty");
		RequestDispatcher rd=request.getRequestDispatcher("Home.html");
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
