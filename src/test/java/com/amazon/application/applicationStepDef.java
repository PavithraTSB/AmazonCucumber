package com.amazon.application;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Excel.Utils.ReadExceldata;
import com.Excel.Utils.WriteDatainProperties;
import com.Excel.Utils.WriteExceldata;
import com.Function.Libraries.Actionss;
import com.Function.Libraries.snapShot;
import com.Function.Libraries.waitClass;
import com.Function.Libraries.windowHandles;
import com.page.object.PageObjects;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class applicationStepDef {

	public static WebDriver driver;
	 //PageObjects pob = new PageObjects();
	static Properties prop=new Properties();
	public static ReadExceldata readExcel=new ReadExceldata();
	public static WriteExceldata writeExcel=new WriteExceldata();
	public static WriteDatainProperties writeProp=new WriteDatainProperties();
	public static windowHandles winHan=new windowHandles();
	public static snapShot screenshot=new snapShot();
	public static LinkedHashMap<String,String>retreiveData=new LinkedHashMap<>();
	public static waitClass wait=new waitClass();

@Given ("^Launch the url \"(.*)\"$")
public void launchURL(String url) throws Exception
{
	try {
		System.setProperty("WebDriver.chrome.driver", "./Driver.chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		com.Function.Libraries.waitClass.implicitwait();
		driver.get(url);
		System.out.println("Application launched successfully");
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Print error msg"+e.getMessage());
		throw new Exception(e);

	}
	
	
}

@When("^I enter the valid \"(.*)\" and \"(.*)\"$")
public void loginApp(String Uname,String Pwd,DataTable table) throws Exception {
	
	try {
		com.Function.Libraries.waitClass.implicitwait();
	    WebElement login=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
 	    Actionss.target=login;		
 	    Actionss.actionClass();
	   // login.click();
	    //pob.clickLogin();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(Uname);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(Pwd);
		screenshot.screenshot();
		driver.findElement(By.id("signInSubmit")).click();
		
		
//		Map<String,String>data=table.asMap(String.class,String.class);
//		for (String key : data.keySet()) {
//			System.out.println(String.format("key : %s , value: %s", data.get(key)));
			
		

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Print error msg"+e.getMessage());
		throw new Exception(e);

	}
	}


@Then("^User should be able to login successfully and validate$")
public void loginValidation() throws Exception {
	
	prop.load(new FileInputStream(new File("./src/test/resources/Config/object.properties")));
	String validationText;
	
	try {
		waitClass.implicitwait();
		WebElement text=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		validationText=text.getText();
		//System.out.println("Print the Validation Text ="+validationText);
		Assert.assertEquals(prop.getProperty("loginValidationText"), validationText);
		System.out.println("Logged in successfully and validated text");
		
	} catch (Exception e) {
		System.out.println("Print error msg"+e.getMessage());
		throw new Exception(e);
	}
	
}

@Given("^Accessing the list of categories \"(.*)\"$")
public static LinkedHashMap<String, String> accessing_the_list_of_categories(int datarow) throws Exception {
	String exceldata;
	String category;
	String subCategory;
	String brands;
	prop.load(new FileInputStream(new File("./src/test/resources/config/object.properties")));
	//int datarow=Integer.parseInt(Row);
	
	try {
		waitClass.implicitwait();
		List<WebElement>categorylist=driver.findElements(By.xpath("//a[@class='nav-a  ']"));
		for(int i=0;i<categorylist.size();i++) {
		category=categorylist.get(i).getText();
		exceldata=readExcel.getCellData(prop.getProperty("Filename"),"AmazonCategories", datarow, 0);
		if(category.equalsIgnoreCase(exceldata))
		{
			Thread.sleep(3000);
			categorylist.get(i).click();
			Thread.sleep(3000);
			//System.out.println("Category clicked"+category);
			List<WebElement>subCategorylist=driver.findElements(By.xpath("//a[contains(@class,'a-color-base a-link-normal')]"));
			for(int j=0;j<subCategorylist.size();j++) {
				subCategory=subCategorylist.get(j).getText();
		    	exceldata=readExcel.getCellData(prop.getProperty("Filename"),"AmazonCategories", datarow, 1);
		    	if(subCategory.equalsIgnoreCase(exceldata)) {
		    		subCategorylist.get(j).click();
		    		Thread.sleep(3000);
		    		List<WebElement>brandslist=driver.findElements(By.xpath("//span[text()='Brands']/following::span[@class='a-size-base a-color-base']"));
                     for(int k=0;k<brandslist.size();k++) {
		    			brands=brandslist.get(k).getText();
		    			exceldata=readExcel.getCellData(prop.getProperty("Filename"),"AmazonCategories", datarow, 2);
		    			if(brands.equalsIgnoreCase(exceldata))
		    			{
		    				if(!brandslist.get(k).isSelected())
		    				brandslist.get(k).click();
		    				Thread.sleep(3000);
		    				WebElement Link=driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
		    				String getLink=Link.getAttribute("href");
		    				retreiveData.put(readExcel.getCellData(prop.getProperty("Filename"),"AmazonCategories", datarow, 0), getLink);
		    				
		    				
		    				}
		    			brandslist=driver.findElements(By.xpath("//span[text()='Brands']/following::span[@class='a-size-base a-color-base']"));
		    			
		    			}
		    		
		    	}
		    	subCategorylist=driver.findElements(By.xpath("//a[contains(@class,'a-color-base a-link-normal')]"));
		    }
		}
		categorylist=driver.findElements(By.xpath("//a[contains(@class,'nav-a')]"));
		
		}
		
		
	} catch (Exception e) {
		System.out.println("Print error msg"+e.getMessage());
		throw new Exception(e);
	}
	
	return retreiveData;
}
@When("^Clicking on the selected image$")
public static void click_on_selected_image() throws Exception {
	
	try {
		com.Function.Libraries.waitClass.implicitwait();
		driver.findElement(By.xpath("//img[@class='s-image']")).click();
		winHan.window_Handles();
	} catch (Exception e) {
		System.out.println("Print error message ="+e.getMessage());
		throw new Exception();
	} 
	
	
}


@Then("^Logout application$")
public static void Logout_application() throws Exception {
	
	try {
		com.Function.Libraries.waitClass.implicitwait();
		driver.findElement(By.xpath("//span[@class='hm-icon-label']")).click();
     	Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//driver.close();
		System.out.println("Print Logout");
	} catch (Exception e) {
		System.out.println("Print error msg"+e.getMessage());
		throw new Exception(e);
	
	}
}

@And("^Write the retreived data in property file$")
public static void writeData() throws Exception {
	
	try {
		writeProp.WriteProperty(retreiveData);
		
	} catch (Exception e) {
		System.out.println("Print error msg"+e.getMessage());
		throw new Exception(e);
	}
}

}
