package com.app.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWriter {

	public static void main(String[] args) throws Exception {
		
		String testDataPath = "./src/test/resources/testdata/Employees.xlsx"; 
		
		//Create file input stream
		
		FileInputStream inStream= new FileInputStream(testDataPath); 
		
		Workbook workbook= WorkbookFactory.create(inStream); 
		Sheet worksheet= workbook.getSheet("Sheet1"); 
		Cell job= worksheet.getRow(4).getCell(2);
		job.setCellValue("auto");
		//save changes
		FileOutputStream outStream= new FileOutputStream(testDataPath); 
		workbook.write(outStream);
		
		outStream.close();
		workbook.close();
		inStream.close();
		
	}
	
}
