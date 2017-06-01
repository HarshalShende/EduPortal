package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.eduportal.model.MaterialInfo;



public class MaterialDao {
	
	public ArrayList<MaterialInfo> geMaterials(String bname)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<MaterialInfo> mlist=new ArrayList<MaterialInfo>();
		try
		{
			pst=con.prepareStatement("select * from material where bname=?");
			pst.setString(1, bname);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				MaterialInfo mobj=new MaterialInfo();
				mobj.setMno(rs.getString(1));
				mobj.setBname(rs.getString(2));
				mobj.setFileloc(rs.getString(3));
				mobj.setFid(rs.getString(4));
				mlist.add(mobj);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mlist;
		
	}
	
	public boolean uploadMaterialRecord(String bname,String fid,String fileloc)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int i=0;
		try
		{
			pst=con.prepareStatement("select fname from facultyrec where fid=?;");
			pst.setString(1,fid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				fid=rs.getString(1);
			pst=con.prepareStatement("insert into material(bname,fileloc,fid) values(?,?,?);");
			//pst.setInt(1, mno);
			pst.setString(1, bname);
			pst.setString(2, fileloc);
			pst.setString(3, fid);
			
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
	
	public ArrayList<MaterialInfo> getAssignmentSubmission(String bname)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<MaterialInfo> alist=new ArrayList<MaterialInfo>();
		try
		{
			pst=con.prepareStatement("select * from material where bname=?;");
			pst.setString(1, bname);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				MaterialInfo mobj=new MaterialInfo();
				mobj.setMno(rs.getString(1));
				mobj.setBname(rs.getString(2));
				mobj.setFileloc(rs.getString(3));
				mobj.setFid(rs.getString(4));
				alist.add(mobj);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alist;
	}

}