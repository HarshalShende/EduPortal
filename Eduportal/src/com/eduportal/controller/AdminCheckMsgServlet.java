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

import com.eduportal.dao.MessageDao;
import com.eduportal.model.QueryMsgInfo;

/**
 * Servlet implementation class AdminCheckMsgServlet
 */
@WebServlet("/AdminCheckMsgServlet")
public class AdminCheckMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		QueryMsgInfo qob=new QueryMsgInfo();
		List<QueryMsgInfo> qlist=new ArrayList<QueryMsgInfo>();
		MessageDao mdao=new MessageDao();
		qlist=mdao.retrieveQueryMsg();
		RequestDispatcher rd=request.getRequestDispatcher("AdminQueryMsg.jsp");
		request.setAttribute("querylist", qlist);
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
