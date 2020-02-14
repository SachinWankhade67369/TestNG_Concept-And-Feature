package com.DataProviderConcept.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DataProviderConcept.Util.YahooTestUtil;

public class YahooCreateAccount {

	public static WebDriver driver;
	
	@BeforeMethod
	public void setUpEnvironment()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Test WorkSpace\\TestNGConceptAndFeatures\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/account/create");
		
	}
	
	@DataProvider
	public Object[][] getTestData() throws Exception {
		
		Object [][] data=YahooTestUtil.getTestData("RegAccountTestData");
		return data;
	}
	
	
	@Test(dataProvider="getTestData")
	public void yahooRegPageTest(String Firstname,String Lastname,String Email,String Password,
			String BirthMonth,String Day,String Year,String Gender) {
		//enter data
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-firstName')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-firstName')]")).sendKeys(Firstname);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-lastName')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-lastName')]")).sendKeys(Lastname);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-yid')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-yid')]")).sendKeys(Email);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-password')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-password')]")).sendKeys(Password);
		
		Select select = new Select(driver.findElement(By.xpath("//select[contains(@id,'usernamereg-month')]")));
		select.selectByVisibleText(BirthMonth);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-day')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-day')]")).sendKeys(Day);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-year')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-year')]")).sendKeys(Year);
		
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-freeformGender')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'usernamereg-freeformGender')]")).sendKeys(Gender);
		
		
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
