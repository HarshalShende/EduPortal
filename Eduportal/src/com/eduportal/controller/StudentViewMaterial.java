package com.eduportal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.AssignmentDao;
import com.eduportal.dao.MaterialDao;
import com.eduportal.model.AssignmentSubmissionInfo;
import com.eduportal.model.MaterialInfo;
import com.eduportal.model.NotificationInfo;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class StudentViewMaterial
 */
@WebServlet("/StudentViewMaterial")
public class StudentViewMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentViewMaterial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		MaterialDao ad=new MaterialDao();
		ArrayList<MaterialInfo> mlist=new ArrayList<MaterialInfo>();
		HttpSession ses=request.getSession(false);
		String sid=(String)ses.getAttribute("sid");
		StudentInfo sobj=(StudentInfo)ses.getAttribute("sinfo");
		String batch=sobj.getBatch();
		
		System.out.println(batch);
		mlist=ad.geMaterials(batch);
		
		RequestDispatcher rd;
		
		ArrayList<NotificationInfo> nlist=new ArrayList<NotificationInfo>();
		ses.setAttribute("notification",nlist);
		
		if(!mlist.isEmpty())
		{
		System.out.println(mlist.get(0).getBname());
		request.setAttribute("minfo", mlist);
		rd=request.getRequestDispatcher("StudentViewMaterial.jsp");
		}
		else
			rd=request.getRequestDispatcher("MaterialError.jsp");
		
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
