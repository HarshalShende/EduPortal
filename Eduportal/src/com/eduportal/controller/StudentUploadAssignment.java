package com.eduportal.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.eduportal.dao.AssignmentDao;
import com.eduportal.dao.AttendanceDao;
import com.eduportal.model.AssignmentInfo;
import com.eduportal.model.AttendanceInfo;
import com.eduportal.model.StudentInfo;

/**
 * Servlet implementation class StudentUploadAssignment
 */
@WebServlet("/StudentUploadAssignment")
public class StudentUploadAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUploadAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		//File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(new File("E:\\UploadedFile\\Temp"));
		this.uploader = new ServletFileUpload(fileFactory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		String msg="";
		String fileloc="";
		HttpSession ses=request.getSession(false);
		StudentInfo sobj=(StudentInfo)ses.getAttribute("sinfo");
		String fid=(String)ses.getAttribute("assfid");
		ses.removeAttribute("assfid");
		String sid=sobj.getId();
		//String fid=request.getParameter("fid");
		System.out.println("Fid= "+fid);
		
		AttendanceDao at=new AttendanceDao();
		float ap=at.getAttendance(sid,fid);
		System.out.println("Attendance: "+ap);
		
		if(ap >86.0){
		
		
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName="+fileItem.getFieldName());
				System.out.println("FileName="+fileItem.getName());
				System.out.println("ContentType="+fileItem.getContentType());
				System.out.println("Size in bytes="+fileItem.getSize());
				fileloc = "E:\\UploadedFile\\AssignmentSubmission\\"+fileItem.getName();
				File file = new File(fileloc);//request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
				System.out.println("Absolute Path at server="+file.getAbsolutePath());
				fileItem.write(file);
				msg = "File Name : "+fileItem.getName()+ " <br /> Uploaded Successfully.";
				//out.write("File "+fileItem.getName()+ " uploaded successfully.");
				//out.write("<br>");
				//out.write("<a href=\"UploadDownloadFileServlet?fileName="+fileItem.getName()+"\">Download "+fileItem.getName()+"</a>");
			}
		} catch (FileUploadException e) {
			//out.write("Exception in uploading file.");
			msg = "Exception in uploading file.";
		} catch (Exception e) {
			//out.write("Exception in uploading file.");
			msg = "Exception in uploading file.";
		}
		
		AssignmentDao adao=new AssignmentDao();
		int qno=(int)ses.getAttribute("assno");
		boolean check=adao.isExists(qno,sid,fid);
		if(check)
		{
			boolean f=adao.delAssignment(qno,sid,fid);
		    System.out.println("Old Deleted");
			//ses.removeAttribute("assno");
		}
			boolean flg=adao.uploadAssignmentRecord(qno, sid, fileloc);
			
			if(flg)
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentHomepage.jsp");
				rd.forward(request, response);
			}
		}
	
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("AttendanceError.jsp");
			rd.forward(request, response);
		}
	}

}
