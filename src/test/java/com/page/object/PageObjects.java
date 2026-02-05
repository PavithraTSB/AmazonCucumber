package com.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class PageObjects {
	
	@FindBy(how=How.XPATH,using="(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]")
	private WebElement login;
	
	public PageObjects() {
		PageFactory.initElements(com.amazon.application.applicationStepDef.driver, this);
	}
	
	public void clickLogin() {
		login.click();
	}
	

}
