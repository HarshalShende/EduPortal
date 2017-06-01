package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.eduportal.model.SubjectInfo;

public class SubjectDao {

	public ArrayList<SubjectInfo> getSubjects()
	{
		ArrayList<SubjectInfo> slist=new ArrayList<SubjectInfo>();
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		SubjectInfo sobj=new SubjectInfo();
		try
		{
			pst=con.prepareStatement("select * from subjects;");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				sobj.setScode(rs.getString(1));
				sobj.setSname(rs.getString(2));
				sobj.setSem(rs.getString(3));
				slist.add(sobj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return slist;
	}
	
	public boolean addSubject(String scode,String sname, String sem)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int i=0;
		try
		{
			pst=con.prepareStatement("select scode from subjects where scode=?;");
			pst.setString(1, scode);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return false;
			}
			else
			{
			pst=con.prepareStatement("insert into subjects values(?,?,?);");
			pst.setString(1, scode);
			pst.setString(2, sname);
			pst.setString(3, sem);
			i=pst.executeUpdate();
			}
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
	
	
}
