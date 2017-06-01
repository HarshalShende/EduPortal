package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.eduportal.model.NotificationInfo;
import com.eduportal.model.StudentInfo;

public class StudentDao {
	public boolean insertRecord(StudentInfo sobj,String tablename)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("insert into "+tablename+"(sid,sname,uname,password,dob,gender,permAddr,presentAddr,phn,mob,email,batch,stream) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//pst.setString(1, tablename);
			pst.setString(1, sobj.getId());
			pst.setString(2, sobj.getName());
			pst.setString(3, sobj.getUname());
			pst.setString(4, sobj.getPass());
			pst.setString(5, sobj.getDob());
			pst.setString(6, sobj.getGender());
			pst.setString(7, sobj.getPermaddr());
			pst.setString(8, sobj.getPresentaddr());
			pst.setString(9, sobj.getResPh());
			pst.setString(10, sobj.getMob());
			pst.setString(11, sobj.getEmail());
			pst.setString(12, sobj.getBatch());
			pst.setString(13, sobj.getStream());
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e){e.printStackTrace();}
		
		return f;
		
	}
	
	public String getRoll(String uid)
	{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String roll = null;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select sid from approvedstudent where uname=?");
			pst.setString(1, uid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				roll=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{}
		return roll;
	}

	
	public boolean updateScore(String sid,int score,String tablename)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("update "+tablename+" set escore=? where sid=?;");
			pst.setInt(1, score);
			pst.setString(2, sid);
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
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
		   pst = con.prepareStatement("select * from approvedstudent where uname=? and password=?");
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
	public List<StudentInfo> listUnappprovedStudent()
	{
		StudentInfo sob=null;
		PreparedStatement pst=null;
		Connection con=null;
		List<StudentInfo> slist=new ArrayList<StudentInfo>();
		
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select sid,sname,escore from studentrec order by escore desc;");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				/*sob=new StudentInfo();
				sob.setId(rs.getString(1));
				sob.setName(rs.getString(2));
				sob.setUname(rs.getString(3));
				sob.setPass(rs.getString(4));
				sob.setDob(rs.getString(5));
				sob.setGender(rs.getString(6));
				sob.setPermaddr(rs.getString(7));
				sob.setPresentaddr(rs.getString(8));
				sob.setResPh(rs.getString(9));
				sob.setMob(rs.getString(10));*/
				
				//String str=rs.getString(1);
				sob=new StudentInfo();
				sob.setId(rs.getString(1));
				sob.setName(rs.getString(2));
				sob.setEscore(rs.getInt(3));
				
				slist.add(sob);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return slist;
		
	}
	
	public StudentInfo listStudentInfo(String id)
	{
		//StudentInfo sob=null;
		PreparedStatement pst=null;
		Connection con=null;
		StudentInfo sob=new StudentInfo();
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select * from studentrec where sid=?;");
			pst.setString(1, id);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				//sob=new StudentInfo();
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
				sob.setEscore(rs.getInt(12));
				//sob.setBatch(rs.getString(13));
							
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sob;
	}
	
	public StudentInfo listStudentInfoFromUname(String uname)
	{
		PreparedStatement pst=null;
		Connection con=null;
		StudentInfo sob=new StudentInfo();
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select * from approvedstudent where uname=?;");
			pst.setString(1, uname);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				//sob=new StudentInfo();
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
				sob.setEscore(rs.getInt(12));
				sob.setBatch(rs.getString(13));
							
				
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
		boolean f=false;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("delete from "+tablename+" where sid=?;");
			//pst.setString(1, tablename);
			pst.setString(1, sid);
			pst.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<NotificationInfo> getnoti(String roll)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<NotificationInfo> nlist=new ArrayList<NotificationInfo>();
		
		try
		{
			con=DBConnection.getMySQlConnection();
			ps=(PreparedStatement) con.prepareStatement("select * from unviewednotification where sid=?");  
            ps.setString(1, roll);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
            	NotificationInfo ninfo=new NotificationInfo();
            	ninfo.setHeading(rs.getString(1));
            	ninfo.setMessage(rs.getString(2));
            	ninfo.setTag(rs.getString(3));
            	ninfo.setRoll(rs.getString(4));
            	
            	ps=(PreparedStatement)con.prepareStatement("delete from unviewednotification where sid=?");
            	ps.setString(1, roll);
            	int i=ps.executeUpdate();
            	
            	ps=con.prepareStatement("insert into viewednotification values(?,?,?,?);");
            	ps.setString(1,rs.getString(1));
            	ps.setString(2,rs.getString(2));
            	ps.setString(3,rs.getString(3));
            	ps.setString(4,rs.getString(4));
            	
            	i=ps.executeUpdate();
            	nlist.add(ninfo);            
            	
            }
            //System.out.println(noti);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return nlist;
	}

	public ArrayList<String> getRollFromBatch(String batch) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ArrayList<String> sroll=new ArrayList<String>();
		try
		{
			pst=con.prepareStatement("select sid from approvedstudent where batch=?;");
			pst.setString(1, batch);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				sroll.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sroll;
		
	}
	
	public boolean checkUsername(String uname)
	{
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		boolean flag=false;
		try
		{
			pst=con.prepareStatement("select uname from approvedstudent where uname=?;");
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

	public boolean changePassword(String oldp, String newp,String sid) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getMySQlConnection();
		PreparedStatement pst=null;
		int i=0;
		
		try
		{
			pst=con.prepareStatement("update approvedstudent set password=? where password=? and sid=?;");
			pst.setString(1, newp);
			pst.setString(2, oldp);
			pst.setString(3,sid);
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
