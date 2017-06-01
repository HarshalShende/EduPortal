package com.eduportal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.QuestionDao;
import com.eduportal.model.QuestionInfo;

/**
 * Servlet implementation class SetQuestionServlet
 */
@WebServlet("/SetQuestionServlet")
public class SetQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		QuestionInfo obj=new QuestionInfo();
		obj.setWeight(Integer.parseInt(request.getParameter("qweight")));
		obj.setSem(request.getParameter("qsem"));
		if(request.getParameter("qsem").equals("Entrance"))
			obj.setSub("Entrance");
		else
			obj.setSub(request.getParameter("qsub"));
		obj.setQues(request.getParameter("question"));
		obj.setOp1(request.getParameter("qop1"));
		obj.setOp2(request.getParameter("qop2"));
		obj.setOp3(request.getParameter("qop3"));
		obj.setOp4(request.getParameter("qop4"));
		obj.setAns(Integer.parseInt(request.getParameter("qans")));
		
		QuestionDao qdao=new QuestionDao();
		boolean flg=qdao.insertRecord(obj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
