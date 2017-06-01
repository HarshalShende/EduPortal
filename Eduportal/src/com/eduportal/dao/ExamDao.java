package com.eduportal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.eduportal.model.ExamResultInfo;

public class ExamDao {

	
	public boolean addExam(String batch,String sub,Date ldt)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		StudentDao sdao=new StudentDao();
		ArrayList<String> stroll=sdao.getRollFromBatch(batch);
		int i=0;
		try
		{
			pst=con.prepareStatement("select examno from temp;");
			ResultSet rs=pst.executeQuery();
			int eno=0;
			if(rs.next())
				eno=rs.getInt(1);
			pst=con.prepareStatement("update temp set examno=examno+1;");
			pst.executeUpdate();
			
			for(String roll:stroll)
			{
				pst=con.prepareStatement("insert into setexamrecord values(?,?,?,?);");
				pst.setInt(1, eno);
				pst.setString(2, roll);
				pst.setString(3, sub);
				pst.setDate(4, ldt);
				
				i=pst.executeUpdate();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(i>0)
		{
			return true;
		}
		else
			return false;
	}

	public void saveExamResult(ExamResultInfo eobj) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("insert into examresult(eno,batch,sid,subject,result) values(?,?,?,?,?);");
			pst.setInt(1, eobj.getEno());
			pst.setString(2, eobj.getBatch());
			pst.setString(3, eobj.getSid());
			pst.setString(4, eobj.getSubject());
			pst.setInt(5, eobj.getResult());
			
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public ArrayList<ExamResultInfo> getExam(String sid)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<ExamResultInfo> elist=new ArrayList<ExamResultInfo>();
		ResultSet rs=null;
		try
		{
			/*pst=con.prepareStatement("select batch from approvedstudent where uname=?;");
			pst.setString(1, uname);
			rs=pst.executeQuery();
			String btc=null;
			if(rs.next())
			{
				btc=rs.getString(1);
			}*/
			pst=con.prepareStatement("select subject,eno from setexamrecord where sid=? and curdate()<expirydate;");
			pst.setString(1, sid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				ExamResultInfo ob=new ExamResultInfo();
				ob.setSubject(rs.getString(1));
				ob.setEno(rs.getInt(2));
				elist.add(ob);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return elist;
	}
	

	public void deleteExamRecord(String id, int eno) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("delete from setexamrecord where sid=? and eno=?;");
			pst.setString(1, id);
			pst.setInt(2, eno);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public ArrayList<ExamResultInfo> getPastExamRecord(String batch) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<ExamResultInfo> elist=new ArrayList<ExamResultInfo>();
		try
		{
			pst=con.prepareStatement("select eno,subject,batch from examresult where batch=?;");
			pst.setString(1, batch);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			ExamResultInfo eob=new ExamResultInfo();
			eob.setEno(rs.getInt(1));
			eob.setSubject(rs.getString(2));
			eob.setBatch(rs.getString(3));
			//eob.setLastdate(rs.getDate(4));
			elist.add(eob);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return elist;
	}

	public ArrayList<ExamResultInfo> getPastResult(int eno) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<ExamResultInfo> elist=new ArrayList<ExamResultInfo>();
		try
		{
			pst=con.prepareStatement("select * from examresult where eno=?;");
			pst.setInt(1, eno);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			ExamResultInfo eob=new ExamResultInfo();
			eob.setEno(rs.getInt(1));
			eob.setBatch(rs.getString(2));
			eob.setSid(rs.getString(3));
			eob.setSubject(rs.getString(4));
			eob.setResult(rs.getInt(5));
			elist.add(eob);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return elist;
	}
	
	public ArrayList<ExamResultInfo> facultyGetExam()
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<ExamResultInfo> elist=new ArrayList<ExamResultInfo>();
		ResultSet rs=null;
		try
		{
			/*pst=con.prepareStatement("select batch from approvedstudent where uname=?;");
			pst.setString(1, uname);
			rs=pst.executeQuery();
			String btc=null;
			if(rs.next())
			{
				btc=rs.getString(1);
			}*/
			pst=con.prepareStatement("select distinct subject,eno,expirydate from setexamrecord where expirydate>date_sub(curdate(),INTERVAL 1 MONTH);");
			//pst.setString(1, sid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				ExamResultInfo ob=new ExamResultInfo();
				ob.setSubject(rs.getString(1));
				ob.setEno(rs.getInt(2));
				ob.setEdate(rs.getDate(3));
				elist.add(ob);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return elist;
	}
	
	public void modifyExamDate(int eno,Date edate)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("update setexamrecord set expirydate=? where eno=?;");
			pst.setDate(1, edate);
			pst.setInt(2, eno);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
