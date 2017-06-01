package com.eduportal.dao;

import org.apache.catalina.valves.CometConnectionManagerValve;

import com.eduportal.model.QueryMsgInfo;
import com.eduportal.model.QuestionInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
	
	public boolean storeQueryMsg(QueryMsgInfo obj)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean f=false;
		con=DBConnection.getMySQlConnection();
		try
		{
		pst=con.prepareStatement("insert into querymsg values(?,?,?);");
		pst.setString(1, obj.getSndrName());
		pst.setString(2, obj.getSndrMail());
		pst.setString(3, obj.getSndrMsg());
		int n=pst.executeUpdate();
		if(n>0)
			f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
		
	}
	public List<QueryMsgInfo> retrieveQueryMsg()
	{
		Connection con=null;
		PreparedStatement pst=null;
		List<QueryMsgInfo> qlist=new ArrayList<QueryMsgInfo>();
		con=DBConnection.getMySQlConnection();
		try
		{
			pst=con.prepareStatement("select * from querymsg;");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QueryMsgInfo qobj=new QueryMsgInfo();
				qobj.setSndrName(rs.getString(1));
				qobj.setSndrMail(rs.getString(2));
				qobj.setSndrMsg(rs.getString(3));
				qlist.add(qobj);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return qlist;
	}

}
