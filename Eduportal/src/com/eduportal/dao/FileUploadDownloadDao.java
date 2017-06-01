package com.eduportal.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileUploadDownloadDao implements Serializable {
	
	public boolean insertfileuploadRecord(String fname,String fileloc,String dt)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("insert into assignments values(?,?,?);");
			pst.setString(1, fname);
			pst.setString(2, fileloc);
			pst.setString(3, dt);
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public int setAssignment(String batch,String ques,String teacher,String sub,Date edt)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int assno = 0;
		try
		{
			pst=con.prepareStatement("select assno from temp;");
			ResultSet rs=pst.executeQuery();
			
			if(!rs.next())
			{
				assno=1;
				pst=con.prepareStatement("insert into temp(assno) values(?);");
				pst.setInt(1, 1);
				pst.executeUpdate();
			}
			else
				assno=rs.getInt(1)+1;
			/*pst=con.prepareStatement("delete from temp;");
			pst.executeUpdate();*/
			//pst=con.prepareStatement("insert into temp values(?,?);");
			pst=con.prepareStatement("update temp set assno=? where assno=?;");
			pst.setInt(1, assno);
			pst.setInt(2, assno-1);
			pst.executeUpdate();
			pst=con.prepareStatement("insert into setassignment(qno,batch,question,teacher,subject,expirydate) values(?,?,?,?,?,?);");
			pst.setInt(1, assno);
			pst.setString(2, batch);
			pst.setString(3, ques);
			pst.setString(4, teacher);
			pst.setString(5, sub);
			pst.setDate(6, edt);
			pst.executeUpdate();
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		return assno;
	}
	
	public void setSampleSolution(int qno,String loc)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		try
		{
			pst=con.prepareStatement("update setassignment set solution=? where qno=?;");
			pst.setString(1, loc);
			pst.setInt(2, qno);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
