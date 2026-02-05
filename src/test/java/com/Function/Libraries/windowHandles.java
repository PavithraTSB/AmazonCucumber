package com.Function.Libraries;

import java.util.Iterator;
import java.util.Set;

public class windowHandles {
	
	static String parentWindow;
	public static snapShot screenshot=new snapShot();
  
	public static void window_Handles() throws Exception {
		
		try {
			parentWindow= com.amazon.application.applicationStepDef.driver.getWindowHandle();
			Set<String>allWindowHandles= com.amazon.application.applicationStepDef.driver.getWindowHandles();
			
			Iterator<String>itr=allWindowHandles.iterator();
			while(itr.hasNext()) {
				String childWindow=itr.next();
				if(!parentWindow.equalsIgnoreCase(childWindow)) {
					
					com.amazon.application.applicationStepDef.driver.switchTo().window(childWindow);
					screenshot.screenshot();
					System.out.println("Child Window Title ="+com.amazon.application.applicationStepDef.driver.switchTo().window(childWindow).getTitle());
					com.amazon.application.applicationStepDef.driver.close();
					
				}
			}
			
			
			com.amazon.application.applicationStepDef.driver.switchTo().window(parentWindow);
		} catch (Exception e) {
			System.out.println("Print error message ="+e.getMessage());
			throw new Exception();
		} 
		
		
		
	}

}
