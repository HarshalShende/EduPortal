package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.eduportal.model.NoticeInfo;

public class NoticeDao {
	
	public int saveNotice(NoticeInfo obj)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int nid=0;
		try
		{
			pst=con.prepareStatement("insert into notice(batch,msg) values(?,?);");
			pst.setString(1, obj.getBatch());
			pst.setString(2, obj.getMsg());
			pst.executeUpdate();
			
			pst=con.prepareStatement("select count(*) from notice;");
			ResultSet rs=pst.executeQuery();
			rs.next();
			nid=rs.getInt(1);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		
		return nid;
	}
	
	public void uploadNoticePath(int id,String path)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("update notice set fileloc=? where id=?;");
			pst.setString(1, path);
			pst.setInt(2, id);
			pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
