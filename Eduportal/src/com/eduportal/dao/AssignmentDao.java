package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.eduportal.model.AssignmentInfo;
import com.eduportal.model.AssignmentSubmissionInfo;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class AssignmentDao {
	
	public ArrayList<AssignmentInfo> getAssignments(String batch)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<AssignmentInfo> alist=new ArrayList<AssignmentInfo>();
		try
		{
			pst=con.prepareStatement("select * from setassignment where batch=?;");
			pst.setString(1, batch);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				AssignmentInfo aobj=new AssignmentInfo();
				aobj.setQno(rs.getInt(1));
				aobj.setBatch(rs.getString(2));
				aobj.setQuestion(rs.getString(3));
				aobj.setSolution(rs.getString(4));
				aobj.setTeacher(rs.getString(5));
				aobj.setSubject(rs.getString(6));
				alist.add(aobj);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alist;
		
	}
	
	public boolean uploadAssignmentRecord(int qno,String sid,String fileloc)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int i=0;
		try
		{
			pst=con.prepareStatement("select teacher from setassignment where qno=?;");
			pst.setInt(1, qno);
			ResultSet rs=pst.executeQuery();
			String fid = null;
			if(rs.next())
				fid=rs.getString(1);
			pst=con.prepareStatement("insert into assignments values(?,?,?,?,curdate());");
			pst.setInt(1, qno);
			pst.setString(2, sid);
			pst.setString(3, fid);
			pst.setString(4, fileloc);
			
			i=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(i>0)
			return true;
		else
			return false;
	}
	
	public ArrayList<AssignmentSubmissionInfo> getAssignmentSubmission(String fid)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<AssignmentSubmissionInfo> alist=new ArrayList<AssignmentSubmissionInfo>();
		try
		{
			pst=con.prepareStatement("select * from assignments where fname=?;");
			pst.setString(1, fid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				AssignmentSubmissionInfo aobj=new AssignmentSubmissionInfo();
				aobj.setAno(rs.getInt(1));
				aobj.setSid(rs.getString(2));
				aobj.setFid(rs.getString(3));
				aobj.setFileloc(rs.getString(4));
				aobj.setDate(rs.getString(5));
				
				alist.add(aobj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alist;
	}
	public ArrayList<AssignmentInfo> facultyGetAssignment(String fid)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<AssignmentInfo> alist=new ArrayList<AssignmentInfo>();
		try
		{
			pst=con.prepareStatement("select * from setassignment where teacher=?;");
			pst.setString(1, fid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				AssignmentInfo aobj=new AssignmentInfo();
				aobj.setQno(rs.getInt(1));
				aobj.setBatch(rs.getString(2));
				aobj.setQuestion(rs.getString(3));
				aobj.setSolution(rs.getString(4));
				aobj.setTeacher(rs.getString(5));
				aobj.setSubject(rs.getString(6));
				aobj.setEdate(rs.getDate(7));
				
				alist.add(aobj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alist;
	}
	
	public void modifyAssignment(AssignmentInfo aobj)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("update setassignment set batch=?,question=?,subject=?,expirydate=? where qno=?;");
			pst.setString(1, aobj.getBatch());
			pst.setString(2, aobj.getQuestion());
			pst.setString(3, aobj.getSubject());
			pst.setDate(4, aobj.getEdate());
			pst.setInt(5, aobj.getQno());
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean isExists(int qno, String sid, String fid) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("select ano from assignments where sid=? and fname=? and ano=?;");
			pst.setString(1, sid);
			pst.setString(2, fid);
			pst.setInt(3,qno);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				return true;
			else
				return false;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return false;
	}

	public boolean delAssignment(int qno, String sid, String fid) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("delete from assignments where sid=? and fname=? and ano=?;");
			pst.setString(1, sid);
			pst.setString(2, fid);
			pst.setInt(3,qno);
			int i=pst.executeUpdate();
			if(i>0)
				return true;
			else
				return false;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
