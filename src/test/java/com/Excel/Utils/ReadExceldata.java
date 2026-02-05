package com.Excel.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class ReadExceldata {

	File file=null;
	public static FileInputStream fi =null;
	public static XSSFWorkbook wb=null;
	public static XSSFSheet sh=null;
	public static String data;
	public static XSSFRow row=null;
	public static XSSFCell cell=null;
	
	
	public String getCellData(String Filename,String SheetName,int dataRow,int Index) throws Exception {
		
		try {
			file=new File(System.getProperty("user.dir")+"/src/test/resources/Testdata/"+Filename);
			fi=new FileInputStream(file);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(SheetName);
			data=sh.getRow(dataRow).getCell(Index).toString();
			
			
		} catch (Exception e) {
			System.out.println("Print Error Message" +e.getMessage());
			throw new Exception(e);
		} 
		fi.close();
		return data;
		
		
	}
	
}
