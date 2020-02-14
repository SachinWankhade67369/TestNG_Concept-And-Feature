package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {
	
	@Test
	public void loginPageTest() {
		System.out.println("loginPageTest");
		//int a=1/0;
	}
	
	@Test(dependsOnMethods="loginPageTest")//homePage is depends on the loginPage.if loginPage is failed then 
	//homePage automatically gets ignored/skipped.
	public void homePageTest() {
		System.out.println("automatically");
	}
	
	@Test(dependsOnMethods ="loginPageTest")
	public void serachPageTest() {
		System.out.println("serachPageTest");
	}
	
	@Test(dependsOnMethods="loginPageTest")
	public void RegisterPageTest() {
		System.out.println("RegisterPageTest");
	}
	
}
