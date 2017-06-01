package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.Date;
import com.eduportal.model.BatchInfo;

public class BatchDao {
	
	public boolean updateSemester()
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int i=0;
		try
		{
			pst=con.prepareStatement("delete from batch where semester='8';");
			pst.executeUpdate();
			pst=con.prepareStatement("update batch set semester=semester+1 where curdate()>nextupdatedate;");
			i=pst.executeUpdate();
			pst=con.prepareStatement("update batch set nextupdatedate=DATE_ADD(nextupdatedate,INTERVAL 6 MONTH);");
			pst.executeUpdate();
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
	
	public ArrayList<BatchInfo> getBatches()
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<BatchInfo> blist=new ArrayList<BatchInfo>();
		
		try
		{
			pst=con.prepareStatement("select * from batch;");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			BatchInfo bobj=new BatchInfo();
			bobj.setBname(rs.getString(1));
			bobj.setSem(rs.getString(2));
			blist.add(bobj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return blist;
		
	}
	
	public ArrayList<String> getSubjects(String batch)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<String> sublist=new ArrayList<String>();
		try
		{
			pst=con.prepareStatement("select subjects.sname from batch,subjects where batch.bname=? and batch.semester=subjects.semester;");
			pst.setString(1, batch);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String sub=rs.getString(1);
				sublist.add(sub);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sublist;
	}
	
	public void setBatch(String bname,Date startdate)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("insert into batch values(?,?,date_add(?,interval 6 month));");
			pst.setString(1, bname);
			pst.setString(2, "1");
			pst.setDate(3, startdate);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
