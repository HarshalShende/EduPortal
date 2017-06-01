package com.eduportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getMySQlConnection()
	{
	  Connection con=null;
	  try
	  {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root123");
	  }catch(ClassNotFoundException e){e.printStackTrace();}
	   catch(SQLException e){e.printStackTrace();}
	
	  return con;
	}

}
