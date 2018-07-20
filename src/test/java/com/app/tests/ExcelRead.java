package com.app.tests;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {

	public static void main(String[] args) throws Exception {

		String filePath = "C:\\Users\\Guven Yilmaz\\Desktop\\Employees.xlsx"; 
		
		FileInputStream inStream= new FileInputStream(filePath); 
		
		Workbook workbook=WorkbookFactory.create(inStream); 
		Sheet worksheet= workbook.getSheetAt(0); 
		Row	row= worksheet.getRow(0); 
		Cell cell=row.getCell(0);
		
		System.out.println(cell.toString());
		
	//	int rowsCount= worksheet.getLastRowNum();
		int rowsCount= worksheet.getPhysicalNumberOfRows(); 
		
		System.out.println("row count" + rowsCount);
		//print all first names
		for(int rowNum=1; rowNum<rowsCount; rowNum++){
			
			System.out.println(rowNum+"  -  "+ worksheet.getRow(rowNum).getCell(0));
		}
		
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			
				if(worksheet.getRow(i).getCell(0).equals("John")){
				
				System.out.println("John works as :"  +  worksheet.getRow(i).getCell(2).toString());
				
			}
			
		}
		
		workbook.close();
		inStream.close();
	}

}
