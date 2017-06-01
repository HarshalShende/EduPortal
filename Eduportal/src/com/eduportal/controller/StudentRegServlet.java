package com.eduportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.StudentDao;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class StudentRegServlet
 */
@WebServlet("/StudentRegServlet")
public class StudentRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		StudentInfo sob=new StudentInfo();
		sob.setId(request.getParameter("id"));
		sob.setFname(request.getParameter("sfname"));
		sob.setLname(request.getParameter("slname"));
		sob.setUname(request.getParameter("suname"));
		sob.setPass(request.getParameter("spass"));
		sob.setDob(request.getParameter("stdob"));
		sob.setGender(request.getParameter("stgender"));
		sob.setMob(request.getParameter("stmob"));
		sob.setPermaddr(request.getParameter("stpermanentaddr"));
		sob.setPresentaddr(request.getParameter("stpresentaddr"));
		sob.setResPh(request.getParameter("stresph"));
		
		/*sob.setXschool(request.getParameter("stXschool"));
		sob.setXpersc(request.getParameter("stXpercent"));
		sob.setXIIschool(request.getParameter("stXIIschool"));
		sob.setXIIpersc(request.getParameter("stXIIpercent"));
		sob.setCollege(request.getParameter("stcollege"));
		sob.setCgpa(request.getParameter("stcollegepercent"));*/
		sob.setStream(request.getParameter("ststream"));
		sob.setEmail(request.getParameter("stemail"));
		
		StudentDao sdao=new StudentDao();
		sdao.insertRecord(sob,"studentrec");
		
		HttpSession ses=request.getSession();
		ses.setAttribute("type", "Reg");
		
		RequestDispatcher rd=request.getRequestDispatcher("/ExamRequestServlet");
		request.setAttribute("test", "Entrance");
		request.setAttribute("sid", request.getParameter("id"));
		rd.forward(request, response);
	}

}
