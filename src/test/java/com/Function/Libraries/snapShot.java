package com.Function.Libraries;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.amazon.application.applicationStepDef;

public class snapShot {

	public void screenshot() throws Exception {
		
		try {
			TakesScreenshot scrShot=((TakesScreenshot)applicationStepDef.driver);
			
			File src=scrShot.getScreenshotAs(OutputType.FILE);
			File dest=new File("./snaps/img.png");
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			System.out.println("Print error message ="+e.getMessage());
			throw new Exception();
		} 
	}
}

