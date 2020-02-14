package com.test;

//to fetch TestNG life cycle annotation,kindly create testNg class and select all the checkbox of annotation rather
//than Data Provider.
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGLifeCycle {
	
	/* output -->
	 
	beforeSuite ---setUpEnvinorment
	beforeTest --- launchBrowser
	beforeClass ---enterUrlLoginPage
	
	beforeMethod --- loginTest
	googleLogoTest
	afterMethod ---logoutPage
	
	beforeMethod --- loginTest
	googleTitleTest
	afterMethod ---logoutPage
	
	afterClass --- deleteAllCookies
	afterTest --- closeBrowser
	
	PASSED: googleLogoTest
	PASSED: googleTitleTest*/

	@BeforeSuite
	public void setUpEnvinorment() {
		System.out.println("beforeSuite ---setUpEnvinorment");
	}

	@BeforeTest
	public void launchBrowser() {
		System.out.println("beforeTest --- launchBrowser");
	}

	@BeforeClass
	public void enterUrlLoginPage() {
		System.out.println("beforeClass ---enterUrlLoginPage");
	}
	
	@BeforeMethod
	public void loginTest() {
		System.out.println("beforeMethod --- loginTest");
	}
	
		
	@Test
	public void googleTitleTest() {
		System.out.println("googleTitleTest");
	}

	@Test
	public void googleLogoTest() {
		System.out.println("googleLogoTest");
	}


	@AfterMethod
	public void logoutPage() {
		System.out.println("afterMethod ---logoutPage");
	}


	@AfterClass
	public void deleteAllCookies() {
		System.out.println("afterClass --- deleteAllCookies");
	}


	@AfterTest
	public void closeBrowser() {
		System.out.println("afterTest --- closeBrowser");
	}

	@AfterSuite
	public void QuitBrowser() {
		System.out.println("afterSuite --- QuitBrowser");
	}

}
