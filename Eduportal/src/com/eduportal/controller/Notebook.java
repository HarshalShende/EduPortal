package com.eduportal.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.eduportal.dao.DBConnection;
import com.eduportal.dao.StudentDao;
import com.eduportal.model.NotificationInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Notebook
 */
@WebServlet("/Notebook")
public class Notebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession ses=request.getSession(false);
		String sd=(String) ses.getAttribute("sid");
		System.out.println("sd="+sd);
		String schecker="",s="";
		Connection con=null;
		PreparedStatement ps=null;
		StudentDao sdao=new StudentDao();
		String roll=sdao.getRoll(sd);
		ses.setAttribute("roll", roll);
		String dt=new Date().toString();
		try
        {
            /*Class.forName("com.mysql.jdbc.Driver");  
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");  
			*/
			con=(Connection) DBConnection.getMySQlConnection();
            ps=(PreparedStatement) con.prepareStatement("select * from notebook where sid=?;");
            ps.setString(1, roll);
            ResultSet rs=ps.executeQuery();
            
            
            
            while(rs.next())
            {
            	schecker=rs.getString(1);
            	System.out.println("Schecker= "+schecker);
            	System.out.println(schecker);
            	if(schecker.equals(roll))
            	{
            		System.out.println("loop");
            		s=s+" "+rs.getString(2);
      
            	}
            	
            }
            // out.println(s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
		System.out.println(s);
		//String strmsg=Jsoup.parse(s);
		System.out.println("msg in string: "+Jsoup.clean(s, Whitelist.basic().addTags("div")));
		ServletContext sc = this.getServletContext();

	       request.setAttribute("name",s);
	       request.setAttribute("date", dt);
	       ArrayList<NotificationInfo> nlist=new ArrayList<NotificationInfo>();
			ses.setAttribute("notification",nlist);
			
	        RequestDispatcher rd = sc.getRequestDispatcher("/ShowNotebook.jsp");
	        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
