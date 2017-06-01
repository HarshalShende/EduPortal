package com.eduportal.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.eduportal.dao.AttendanceDao;
import com.eduportal.dao.QuestionDao;
import com.eduportal.model.AttendanceInfo;
import com.eduportal.model.QuestionInfo;

public class GetAttendanceFromExcel {

	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file
	   

	    
	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	    

	    //Create a loop over all the rows of excel file to read it
	    AttendanceInfo aobj=new AttendanceInfo();
	    DataFormatter df=new DataFormatter();

	    for (int i = 1; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);
	        
	        	aobj.setSid(df.formatCellValue(row.getCell(0)));
	        	aobj.setSname(df.formatCellValue(row.getCell(1)));
	        	aobj.setAtn((float)row.getCell(2).getNumericCellValue());
	        	aobj.setFid(df.formatCellValue(row.getCell(3)));
	        	
	        	AttendanceDao adao=new AttendanceDao();
	        	adao.insertRecord(aobj);

	        //}

	        //System.out.println();

	    }
	    } 




}
