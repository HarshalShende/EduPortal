package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduportal.model.AttendanceInfo;
import com.eduportal.model.QuestionInfo;

public class AttendanceDao {
	
	public boolean insertRecord(AttendanceInfo obj)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("insert into attendance(sid,sname,atd,fid) values(?,?,?,?);");
			//pst.setInt(1, obj.getWeight());
			pst.setString(1, obj.getSid());
			pst.setString(2, obj.getSname());
			pst.setFloat(3, obj.getAtn());
			pst.setString(4, obj.getFid());

			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e){e.printStackTrace();}
		
		return f;
	}
	
	
	
	public List<AttendanceInfo> getRecords(String sid)
	{
		Connection con=null;
		PreparedStatement pst=null;
		List<AttendanceInfo> al=new ArrayList<AttendanceInfo>();
		AttendanceInfo aob=null;
		ResultSet rs=null;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select * from attendance where sid=? order by atd desc;");
			rs=pst.executeQuery();
			while(rs.next())
			{
				aob=new AttendanceInfo();
				aob.setSid(rs.getString(1));
				aob.setSname(rs.getString(2));
				aob.setAtn(rs.getFloat(3));
				aob.setFid(rs.getString(4));
				al.add(aob);
				rs.next();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}



	public float getAttendance(String sid, String fid) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		float atd=0.0F;
		try
		{
			pst=con.prepareStatement("select atd from attendance where sid=? and fid=?;");
			pst.setString(1, sid);
			pst.setString(2, fid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				atd=rs.getFloat(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return atd;
	}
}
