package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setUpEnvironment()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Test WorkSpace\\TestNGConceptAndFeatures\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		
	}
	
	
	@Test(priority =1,groups="smoke")
	public void getGoogleTitleTest()
	{
		String title=driver.getTitle();
		//to validate use Assert class..
		Assert.assertEquals(title, "Google");
		//Assert.assertEquals(title, "Google","Title is not match.");
		System.out.println("Title is:"+title);
	}
	
	@Test(priority=2,groups="smoke")
	public void googleLogoTest()
	{
		boolean logo = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(logo);
		//Assert.assertEquals(logo, true);
		
	}
	
	@Test(priority=3,groups="smoke")
	public void gmailLinkTest()
	{
		boolean linkText=driver.findElement(By.linkText("gmail")).isDisplayed();
		Assert.assertEquals(linkText, true);
		
	}
	
	
	@Test(priority=4,groups="Test")
	public void test1()
	{
		System.out.println("test1");
	}
	
	
	@Test(priority=5,groups="Test")
	public void test2()
	{
		System.out.println("test2");
	}
	
	@Test(priority=6,groups="Test")
	public void test3()
	{
		System.out.println("test3");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
}
