package com.Function.Libraries;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actionss {
	public static WebElement target = null;
	public static Actions builder;

	public static void actionClass() {
		
		builder=new Actions(com.amazon.application.applicationStepDef.driver);
		builder.moveToElement(target).click().perform();
		
		}

}
