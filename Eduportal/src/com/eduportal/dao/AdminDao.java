package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
	
	public boolean loginCheck(String uid , String pass)
	{
		
		boolean f=false;
		
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		   pst = con.prepareStatement("select * from adminrec where uname=? and password=?");
		   pst.setString(1, uid);
		   pst.setString(2, pass);
		   		   
		   ResultSet rs = pst.executeQuery();
				     
		   if(rs.next())
		   {    
			   
			   f=true;
		   }
		}catch(SQLException e){e.printStackTrace();}
		finally 
		 {
			 
			 if(pst != null)
			 {
				try {
					pst.close();
				} catch (SQLException e) {e.printStackTrace();}
			 }
			
			 if(con != null)
			 {
				try {
					con.close();
				} catch (SQLException e) {e.printStackTrace();}
			 }
		}
		
	    return f;
	}
	
	public boolean changePassword(String oldp,String newp)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int i=0;
		try
		{
			pst=con.prepareStatement("update adminrec set password=? where password=?;");
			pst.setString(1, newp);
			pst.setString(2, oldp);
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

}
