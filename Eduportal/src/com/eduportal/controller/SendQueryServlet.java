package com.eduportal.controller;

import java.io.IOException;
import java.sql.Clob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduportal.dao.MessageDao;
import com.eduportal.model.QueryMsgInfo;

/**
 * Servlet implementation class SendQueryServlet
 */
@WebServlet("/SendQueryServlet")
public class SendQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendQueryServlet() {
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
		String sndrName=request.getParameter("sendername");
		String sndrMail=request.getParameter("sendermailid");
		String sndrMsg=request.getParameter("sendermsg");
		QueryMsgInfo qobj=new QueryMsgInfo();
		MessageDao mdao=new MessageDao();
		qobj.setSndrName(sndrName);
		qobj.setSndrMail(sndrMail);
		qobj.setSndrMsg(sndrMsg);
		boolean f=mdao.storeQueryMsg(qobj);
		if(f)
			System.out.println("Query sent");
		else
			System.out.println("Failed to send query");
		response.sendRedirect("Home.html");
	}

}
