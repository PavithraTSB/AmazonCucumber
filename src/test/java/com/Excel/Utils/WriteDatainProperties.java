package com.Excel.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class WriteDatainProperties {

	//public static void main(String []args) throws IOException {
	public static void WriteProperty(LinkedHashMap<String,String>map) throws Exception {
		
		String path="./src/test/resources/config/WriteData.properties";
		Properties props=new Properties();
		//LinkedHashMap<String,String>map=new LinkedHashMap<>();
		try {
			File file = new File(path);
			//map.put("Hi", "Helloiiii");
			Set<String>setMap=new HashSet<>();
			setMap=map.keySet();
			
			for (String key : setMap) {
				List<String>dataValues=new ArrayList<>();
				dataValues.add(map.get(key));
				String ListofValues=dataValues.toString();
				props.setProperty(key,ListofValues);
				FileOutputStream os=new FileOutputStream(file);
				props.store(os, "WriteData");
				
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Print error msg"+e.getMessage());
			throw new Exception(e);

		}
		
		
}
	 
	 
	 
}
