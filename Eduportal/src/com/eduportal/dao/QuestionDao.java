package com.eduportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduportal.model.QuestionInfo;
import com.eduportal.model.QuestionLevelLists;

public class QuestionDao {
	
	public boolean insertRecord(QuestionInfo obj)
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean f=false;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("insert into question(semester,subject,question,op1,op2,op3,op4,answer,noc,tot,percentage) values(?,?,?,?,?,?,?,?,?,?,?);");
			//pst.setInt(1, obj.getWeight());
			pst.setString(1, obj.getSem());
			pst.setString(2, obj.getSub());
			pst.setString(3, obj.getQues());
			pst.setString(4, obj.getOp1());
			pst.setString(5, obj.getOp2());
			pst.setString(6, obj.getOp3());
			pst.setString(7, obj.getOp4());
			pst.setInt(8, obj.getAns());
			pst.setInt(9, 0);
			pst.setInt(10, 1);
			pst.setFloat(11, (float) 0.0);
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e){e.printStackTrace();}
		
		return f;
	}
	
	/*public List<QuestionInfo> getRecords(int lvl,String sub)
	{
		Connection con=null;
		PreparedStatement pst=null;
		//QuestionLevelLists lists=new QuestionLevelLists();
		List<QuestionInfo> ql=new ArrayList<QuestionInfo>();
		QuestionInfo qob=null;
		ResultSet rs1=null;
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("select * from question where weight=? and subject=?;");
			pst.setInt(1, lvl);
			pst.setString(2, sub);
			rs1=pst.executeQuery();
			while(rs1.next())
			{
				qob=new QuestionInfo();
				qob.setWeight(rs1.getInt(1));
				qob.setSem(rs1.getString(2));
				qob.setSub(rs1.getString(3));
				qob.setQues(rs1.getString(4));
				qob.setOp1(rs1.getString(5));
				qob.setOp2(rs1.getString(6));
				qob.setOp3(rs1.getString(7));
				qob.setOp4(rs1.getString(8));
				qob.setAns(rs1.getInt(9));
				ql.add(qob);
			}
			
			
		}
		catch(Exception e){e.printStackTrace();}
		return ql;
	}*/
	
	public List<QuestionInfo> getRecords(int lvl,String sub)
	{
		Connection con=null;
		PreparedStatement pst=null;
		//QuestionLevelLists lists=new QuestionLevelLists();
		List<QuestionInfo> ql=new ArrayList<QuestionInfo>();
		QuestionInfo qob=null;
		sub=sub.trim();
		ResultSet rs=null;
		try
		{
			con=DBConnection.getMySQlConnection();
			int count=0;
			System.out.println("Dao sub="+sub+".");
			pst=con.prepareStatement("select count(*) from question where subject=?;");
			pst.setString(1, sub);
			rs=pst.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
				System.out.println("Count= "+count);
			}
			int interval=(count/3)+1;
			pst=con.prepareStatement("select * from question where subject=? order by percentage desc;");
			pst.setString(1, sub);
			rs=pst.executeQuery();
			if(lvl==1)
			{
				if(rs.next())
				{
					for(int i=0;i<interval;i++)
					{
						qob=new QuestionInfo();
						qob.setWeight(rs.getInt(2));
						qob.setQid(rs.getInt(1));
						qob.setSem(rs.getString(3));
						qob.setSub(rs.getString(4));
						qob.setQues(rs.getString(5));
						qob.setOp1(rs.getString(6));
						qob.setOp2(rs.getString(7));
						qob.setOp3(rs.getString(8));
						qob.setOp4(rs.getString(9));
						qob.setAns(rs.getInt(10));
						qob.setNoc(rs.getInt(11));
						qob.setTot(rs.getInt(12));
						qob.setPercentage(rs.getFloat(13));
						ql.add(qob);
						rs.next();
					}
				}
			}
			else if(lvl==2)
			{
				if(rs.next())
				{
					for(int i=0;i<interval;i++)
					{
						rs.next();
					}
					for(int i=interval;i<2*interval;i++)
					{
						qob=new QuestionInfo();
						qob.setWeight(rs.getInt(2));
						qob.setQid(rs.getInt(1));
						qob.setSem(rs.getString(3));
						qob.setSub(rs.getString(4));
						qob.setQues(rs.getString(5));
						qob.setOp1(rs.getString(6));
						qob.setOp2(rs.getString(7));
						qob.setOp3(rs.getString(8));
						qob.setOp4(rs.getString(9));
						qob.setAns(rs.getInt(10));
						qob.setNoc(rs.getInt(11));
						qob.setTot(rs.getInt(12));
						qob.setPercentage(rs.getFloat(13));
						ql.add(qob);
						rs.next();
					}
				}
			}
			else
			{
				if(rs.next())
				{
					for(int i=0;i<2*interval;i++)
					{
						rs.next();
					}
					for(int i=2*interval;i<count;i++)
					{
						qob=new QuestionInfo();
						qob.setWeight(rs.getInt(2));
						qob.setQid(rs.getInt(1));
						qob.setSem(rs.getString(3));
						qob.setSub(rs.getString(4));
						qob.setQues(rs.getString(5));
						qob.setOp1(rs.getString(6));
						qob.setOp2(rs.getString(7));
						qob.setOp3(rs.getString(8));
						qob.setOp4(rs.getString(9));
						qob.setAns(rs.getInt(10));
						qob.setNoc(rs.getInt(11));
						qob.setTot(rs.getInt(12));
						qob.setPercentage(rs.getFloat(13));
						ql.add(qob);
						rs.next();
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ql;
	}
			
	
	
	public void updatePercentage(int qid,int noc,int tot) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		float perc=(noc+1)*100/(tot+1);
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("update question set noc=?,tot=?,percentage=? where qid=?;");
			pst.setInt(1, noc+1);
			pst.setInt(2, tot+1);
			pst.setFloat(3, perc);
			pst.setInt(4, qid);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void updatePercentage(QuestionInfo qob) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int qid=qob.getQid();
		int noc=qob.getNoc();
		int tot=qob.getTot()+1;
		float perc=(noc)*100/(tot);
		try
		{
			con=DBConnection.getMySQlConnection();
			pst=con.prepareStatement("update question set tot=?,percentage=? where qid=?;");
			
			pst.setInt(1, tot);
			pst.setFloat(2, perc);
			pst.setInt(3, qid);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		

}
