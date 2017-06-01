package com.eduportal.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Video
 */
@WebServlet("/Video")
public class Video extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Video() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			ServletContext sc = this.getServletContext();
	        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	        Calendar cal = Calendar.getInstance();
	        System.out.println(dateFormat.format(cal.getTime()));
	         
	        String s="";
	        s=s+dateFormat.format(cal.getTime());
	        String cmd="ffmpeg.exe -f gdigrab -framerate 10 -i desktop "+s+".flv";
	        Runtime.getRuntime().exec(cmd,null,new File("C:\\ffmpeg\\bin"));
	        RequestDispatcher rd = sc.getRequestDispatcher("/stop.jsp");
	        rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
