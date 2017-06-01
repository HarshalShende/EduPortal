package com.eduportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eduportal.dao.ExamDao;
import com.eduportal.dao.QuestionDao;
import com.eduportal.dao.StudentDao;
import com.eduportal.model.ExamResultInfo;
import com.eduportal.model.QuestionInfo;
import com.eduportal.model.QuestionReportInfo;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class CheckExamServlet
 */
@WebServlet("/CheckExamServlet")
public class CheckExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckExamServlet() {
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
		List<QuestionInfo> ql1,ql2,ql3;
		int lim1,lim2,lim3;
		HttpSession ses=request.getSession(false);
		ql1=(ArrayList<QuestionInfo>) ses.getAttribute("qlist1");
		ql2=(ArrayList<QuestionInfo>) ses.getAttribute("qlist2");
		ql3=(ArrayList<QuestionInfo>) ses.getAttribute("qlist3");
		lim1=(int) ses.getAttribute("lim1");
		lim2=(int) ses.getAttribute("lim2");
		lim3=(int) ses.getAttribute("lim1");
		
		int level=Integer.parseInt((String) request.getParameter("qlvl"));
		int option;
		if(request.getParameter("op")==null)
			option=0;
		else
			option=Integer.parseInt((String) request.getParameter("op"));
		int ans=Integer.parseInt((String) request.getParameter("qans"));
		int rno=Integer.parseInt((String) request.getParameter("ran"));
		int quesnum=Integer.parseInt((String) request.getParameter("quesno"));
		int score=Integer.parseInt((String) request.getParameter("qscore"));
		String test=(String) request.getParameter("test");
		int lim = 0;
		//score+=level;
		++quesnum;
		
		List<QuestionInfo> qlst=null;
		QuestionInfo last = null;
		
		if(level==1)
		{
			last=ql1.get(rno);
			
			//qlst=ql1;
			ql1.remove(rno);
			--lim1;
			ses.setAttribute("lim1", lim1);
			ses.setAttribute("qlist1", ql1);
		}
		else if(level==2)
		{
			last=ql2.get(rno);
			//qlst=ql2;
			ql2.remove(rno);
			--lim2;
			ses.setAttribute("lim2", lim2);
			ses.setAttribute("qlist2", ql2);
		}
		else if(level==3)
		{
			last=ql3.get(rno);
			//qlst=ql3;
			ql3.remove(rno);
			--lim3;
			ses.setAttribute("lim3", lim3);
			ses.setAttribute("qlist3", ql3);
		}
		
		QuestionReportInfo repobj=new QuestionReportInfo();
		repobj.setQno(quesnum-1);
		repobj.setQues(last.getQues());
		if(option==1)
			repobj.setYourAns(last.getOp1());
		else if(option==2)
			repobj.setYourAns(last.getOp2());
		else if(option==3)
			repobj.setYourAns(last.getOp3());
		else if(option==4)
			repobj.setYourAns(last.getOp4());
		
		if(ans==1)
			repobj.setCorrectAns(last.getOp1());
		else if(ans==2)
			repobj.setCorrectAns(last.getOp2());
		else if(ans==3)
			repobj.setCorrectAns(last.getOp3());
		else if(ans==4)
			repobj.setCorrectAns(last.getOp4());
		
		
		
		
		//qlst.remove(rno);
		/*QuestionLevelLists ql=new QuestionLevelLists();
		QuestionDao qdao=new QuestionDao();
		ql=qdao.getRecords();*/
		QuestionDao qdao=new QuestionDao();
		if(option==ans)
		{
			repobj.setCorrect(1);
			System.out.println("Last Question: "+last.getQues());
			qdao.updatePercentage(last.getQid(),last.getNoc(),last.getTot());
			score+=level;
			if(level<3)
				++level;
			else
				level=3;
		}
		else
		{
			repobj.setCorrect(0);
			qdao.updatePercentage(last);
			if(level>1)
				--level;
			else
				level=1;
		}
		
		ArrayList<QuestionReportInfo> qrl=(ArrayList<QuestionReportInfo>) ses.getAttribute("report");
		qrl.add(repobj);
		ses.setAttribute("report", qrl);
		
		QuestionInfo qob=new QuestionInfo();
		if(level==1)
			lim=ql1.size();
		else if(level==2)
			lim=ql2.size();
		else if(level==3)
			lim=ql3.size();
		Random rnd=new Random();
		int n=rnd.nextInt(lim);
		//--lim;
		
		if(level==1)
		{
			qob=ql1.get(n);
		}
		else if(level==2)
		{
			qob=ql2.get(n);
			
		}
		else if(level==3)
		{
			qob=ql3.get(n);
		}
		
		if(quesnum<=5)
		{
		RequestDispatcher rd=request.getRequestDispatcher("ExamPage.jsp");
		request.setAttribute("level", level);
		request.setAttribute("qlists", qob);
		request.setAttribute("rno", n);
		request.setAttribute("qnum", quesnum);
		request.setAttribute("score", score);
		request.setAttribute("test", test);
		
		rd.forward(request, response);
		}
		else
		{
			
			request.setAttribute("score", score);
			//request.setAttribute("test", test);
			//HttpSession ses=request.getSession(false);
			String sid=(String) ses.getAttribute("sid");
			String type=(String) ses.getAttribute("type");
			System.out.println("Type= "+type);
			if(type.equals("Reg"))
			{
				StudentDao sdao=new StudentDao();
				sdao.updateScore(sid, score, "studentrec");
				//ses.invalidate();
			}
			else
			{
				ExamDao edao=new ExamDao();
				StudentInfo sinfo=(StudentInfo) ses.getAttribute("sinfo");
				int eno=(int) ses.getAttribute("eno");
				ExamResultInfo eobj=new ExamResultInfo();
				eobj.setEno(eno);
				eobj.setBatch(sinfo.getBatch());
				eobj.setSid(sinfo.getId());
				eobj.setSubject(test);
				eobj.setResult(score);
				edao.saveExamResult(eobj);
				edao.deleteExamRecord(sinfo.getId(),eno);
				
			}
			RequestDispatcher rd=request.getRequestDispatcher("ExamResult.jsp");
			rd.forward(request, response);
		}
		
		
		//doGet(request, response);
	}

}
