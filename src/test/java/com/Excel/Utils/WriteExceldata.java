package com.Excel.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExceldata {
	
	//public static void main(String []args) throws Exception {
	public void WriteData(String Outputfile,int datarow,LinkedHashMap<String,String>map) throws Exception {
		
		XSSFWorkbook wb;
		XSSFSheet sh;
		XSSFFont font;
		XSSFCellStyle style;
		XSSFFont font1;
		XSSFCellStyle style1;
		XSSFRow row;
		XSSFCell cell;
		int rowNum=datarow;
		int cellNum=1;
		int i=0;
		
		try {
			
			File file =new File(System.getProperty("user.dir")+"/src/test/resources/Testdata/"+Outputfile);
			wb=new XSSFWorkbook(file);
			sh=wb.getSheet("Output");
			
			font= wb.createFont();
			font.setFontHeightInPoints((short) 12);
			font.setFontName("Arial");
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setItalic(true);

			style=wb.createCellStyle();
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderTop(BorderStyle.THIN);
			style.setFont(font);
			
			font1= wb.createFont();
			font1.setFontHeightInPoints((short) 10);
			font1.setFontName("Arial");
			font1.setItalic(false);

			style1=wb.createCellStyle();
			style1.setBorderLeft(BorderStyle.THIN);
			style1.setBorderRight(BorderStyle.THIN);
			style1.setBorderBottom(BorderStyle.THIN);
			style1.setBorderTop(BorderStyle.THIN);
			style1.setFont(font1);
			
			row=sh.createRow(0);
			cell=row.createCell(0);
			cell.setCellValue("Category");
			cell.setCellStyle(style);
			
			cell=row.createCell(1);
			cell.setCellValue("Link");
			cell.setCellStyle(style);
			
			cell=row.createCell(2);
			cell.setCellValue("Price");
			cell.setCellStyle(style);
			
			row=sh.createRow(1);
			cell=row.createCell(0);
			cell.setCellValue("Baby");
			cell.setCellStyle(style1);
			
			row=sh.createRow(2);
			cell=row.createCell(0);
			cell.setCellValue("Gift Cards");
			cell.setCellStyle(style1);
			
			//map.put("Hi", "Hello");
		
			Set<String> setMap=new HashSet<>();
			setMap=map.keySet();
			for (String key : setMap) {
				 List<String>dataValues=new ArrayList<>();
			     dataValues.add(map.get(key));
			     
			     if(sh.getRow(rowNum)==null)
			    	 row=sh.createRow(rowNum);
			     else
			    	row.setRowNum(rowNum);
				
			     if(row.getCell(1)==null)
			     {
			    	 cell=row.createCell(1);
			    	 cell.setCellValue(datarow);
			    	 cell.setCellStyle(style1);
			     }
			     cell=row.createCell(cellNum);
			     cell.setCellValue(dataValues.get(i));
			     cell.setCellStyle(style1);
			     cellNum++;
			     
			}
			rowNum++;
			FileOutputStream fs=new FileOutputStream(file);
			wb.write(fs);
			fs.close();
			
			} 
		catch (Exception e) {
			System.out.println("Print error msg"+e.getMessage());
			throw new Exception(e);
			
		} 
		
		   }

}
