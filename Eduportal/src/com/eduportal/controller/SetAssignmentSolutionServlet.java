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

import com.eduportal.dao.FileUploadDownloadDao;

/**
 * Servlet implementation class SetAssignmentSolutionServlet
 */
@WebServlet("/SetAssignmentSolutionServlet")
public class SetAssignmentSolutionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetAssignmentSolutionServlet() {
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
		
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName="+fileItem.getFieldName());
				System.out.println("FileName="+fileItem.getName());
				System.out.println("ContentType="+fileItem.getContentType());
				System.out.println("Size in bytes="+fileItem.getSize());
				fileloc = "E:\\UploadedFile\\TemplateSolution\\"+fileItem.getName();
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
		
		HttpSession ses=request.getSession(false);
		int qno=(int) ses.getAttribute("qno");
		System.out.println("Ass no= "+qno);
		
		FileUploadDownloadDao fdao=new FileUploadDownloadDao();
		fdao.setSampleSolution(qno, fileloc);
		ses.removeAttribute("qno");
		RequestDispatcher rd=request.getRequestDispatcher("FacultyHomepage.jsp");
		rd.forward(request, response);
	}

}
