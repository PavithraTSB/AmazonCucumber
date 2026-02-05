package com.Function.Libraries;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.application.applicationStepDef;

public class waitClass {
	public static WebDriverWait webdriverwait;
	public static Wait<WebDriver>fluentwait;
	
	public static void webdriverwait() {
		
		webdriverwait=new WebDriverWait(com.amazon.application.applicationStepDef.driver,Duration.ofSeconds(30));
		
		}
	
	public static void implicitwait() {
		
		com.amazon.application.applicationStepDef.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static void fluentWait() {
		fluentwait=new FluentWait<WebDriver>(applicationStepDef.driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(Exception.class);
		
		
	}

}
