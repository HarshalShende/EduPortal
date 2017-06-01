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

import com.eduportal.dao.QuestionDao;
import com.eduportal.model.QuestionInfo;
import com.eduportal.model.QuestionReportInfo;

/**
 * Servlet implementation class ExamRequestServlet
 */
@WebServlet("/ExamRequestServlet")
public class ExamRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String test;
		test=(String)request.getAttribute("test");
		if(test==null)
			test=request.getParameter("test");
		System.out.println("Exam req= "+test+".");
		String sid=(String)request.getAttribute("sid");
		int eno=Integer.parseInt(request.getParameter("eno"));
		//System.out.println("suname="+sid);
		List<QuestionInfo> ql=new ArrayList<QuestionInfo>();
		QuestionDao qdao=new QuestionDao();
		//ql=qdao.getRecords(1,test);
		QuestionInfo qob=new QuestionInfo();
		//qob=ql.get(0);
		
		
		List<QuestionInfo> ql1,ql2,ql3;
		ql1=new ArrayList<QuestionInfo>();
    	ql2=new ArrayList<QuestionInfo>();
    	ql3=new ArrayList<QuestionInfo>();
    	
    	//QuestionDao qdao=new QuestionDao();
		ql1=qdao.getRecords(1,test);
		ql2=qdao.getRecords(2,test);
		ql3=qdao.getRecords(3,test);
		
		/*to be removed
		
		System.out.println(ql1.get(0).getQues());
		System.out.println(ql2.get(0).getQues());
		System.out.println(ql3.get(0).getQues());
		System.out.println(ql1.get(1).getQues());
		System.out.println(ql2.get(1).getQues());
		System.out.println(ql3.get(1).getQues());
		
		upto here*/
		
		qob=ql1.get(0);
		
		int lim1=4;
		int lim2=4;
		int lim3=4;
		
		List<QuestionReportInfo> qrl=new ArrayList<QuestionReportInfo>();
		
		
		HttpSession ses=request.getSession(true);
		if(sid!=null)
			ses.setAttribute("sid", sid);
		ses.setAttribute("qlist1", ql1);
		ses.setAttribute("qlist2", ql2);
		ses.setAttribute("qlist3", ql3);
		ses.setAttribute("lim1", lim1);
		ses.setAttribute("lim2", lim2);
		ses.setAttribute("lim3", lim3);
		ses.setAttribute("report", qrl);
		ses.setAttribute("eno", eno);
		
		RequestDispatcher rd=request.getRequestDispatcher("ExamPage.jsp");
		request.setAttribute("qlists", qob);
		request.setAttribute("level", 1);
		request.setAttribute("rno", 0);
		request.setAttribute("qnum", 1);
		request.setAttribute("score", 0);
		request.setAttribute("test", test);
		
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
