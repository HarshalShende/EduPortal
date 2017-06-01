package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduportal.model.FacultyInfo;


public class FacultyDao {
	
	public boolean insertRecord(FacultyInfo fobj,String tablename)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean f=false;
		//String name=fobj.getFname()+" "+fobj.getLname();
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("insert into "+tablename+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			pst.setString(1, fobj.getId());
			pst.setString(2, fobj.getName());
			pst.setString(3, fobj.getUname());
			pst.setString(4, fobj.getPass());
			pst.setString(5, fobj.getDob());
			pst.setString(6, fobj.getGender());
			pst.setString(7, fobj.getPermaddr());
			pst.setString(8, fobj.getPresentaddr());
			pst.setString(9, fobj.getResPh());
			pst.setString(10, fobj.getMob());
			pst.setString(11, fobj.getEmail());
			pst.setString(12, fobj.getSubject());
			pst.setString(13, fobj.getQual());
			pst.setString(14, fobj.getCollege());
			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e){e.printStackTrace();}
		
		return f;
		
	}
	
	public boolean loginCheck(String uid , String pass)
	{
		//StudentInfo cobj= null; 
		boolean f=false;
		
		PreparedStatement pst = null;
 	    Connection con = null;
		try
		{
		   con = DBConnection.getMySQlConnection();
		   pst = con.prepareStatement("select * from facultyrec where uname=? and password=?");
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
	
	public List<String> listUnappprovedFaculty()
	{
		FacultyInfo sob=null;
		PreparedStatement pst=null;
		Connection con=null;
		List<String> slist=new ArrayList<String>();
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select fid from tempfaculty;");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				
				String str=rs.getString(1);
				
				slist.add(str);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return slist;
		
	}
	
	
	public FacultyInfo listFacultyInfo(String id)
	{
		
		PreparedStatement pst=null;
		Connection con=null;
		FacultyInfo sob=new FacultyInfo();
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select * from tempfaculty where fid=?;");
			pst.setString(1, id);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				
				sob.setId(rs.getString(1));
				sob.setName(rs.getString(2));
				sob.setUname(rs.getString(3));
				sob.setPass(rs.getString(4));
				sob.setDob(rs.getString(5));
				sob.setGender(rs.getString(6));
				sob.setPermaddr(rs.getString(7));
				sob.setPresentaddr(rs.getString(8));
				sob.setResPh(rs.getString(9));
				sob.setMob(rs.getString(10));
				sob.setEmail(rs.getString(11));
				sob.setSubject(rs.getString(12));
				sob.setQual(rs.getString(13));
				sob.setCollege(rs.getString(14));
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sob;
	}
	
	public void deleteRecord(String sid,String tablename)
	{
		Connection con=null;
		PreparedStatement pst=null;
		//boolean f=false;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("delete from "+tablename+" where fid=?;");
			//pst.setString(1, tablename);
			pst.setString(1, sid);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public List<String> approvedFacultyName()
	{
		Connection con=null;
		PreparedStatement pst=null;
		con=DBConnection.getMySQlConnection();
		List<String> flist=new ArrayList<String>();
		try
		{
			pst=con.prepareStatement("select fname from facultyrec;");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String name=rs.getString(1);
				flist.add(name);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flist;
	}
	
	public String getFnameFromUname(String uname)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		String fname=null;
		
		try
		{
			pst=con.prepareStatement("select fname,fid from facultyrec where uname=?;");
			pst.setString(1, uname);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				fname=rs.getString(1);
				fname=fname+"/"+rs.getString(2);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return fname;
		
	}
	
	public boolean checkUsername(String uname)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		boolean flag=false;
		try
		{
			pst=con.prepareStatement("select uname from facultyrec where uname=?;");
			pst.setString(1, uname);
			rs=pst.executeQuery();
			if(rs.next())
				flag= true;
			else
				flag= false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public boolean changePassword(String oldp, String newp, String fid) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int i=0;
		
		try
		{
			pst=con.prepareStatement("update facultyrec set password=? where password=? and fid=?;");
			pst.setString(1, newp);
			pst.setString(2, oldp);
			pst.setString(3,fid);
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
