package com.HardAndSoftAssertionsTestNG;
/*
 * Hard Assert :- Hard assert is a kind of assert in which if assert is failed then all the remaining code after
 * 				  assert will not be executed.
 * Soft Assert :- Soft assert is a kind of assert in which if assert is failed then all the remaining code after
 * 				  assert will be executed fine and TestCase will be passed even if the soft assertion failed.
 * 
 * SoftAssert.assertall() :- by using this method,we will return all the failed assertion result and 
 * 							 TestCase will get failed.  
 */

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
		
public class TestCases {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void test1() {
		
		System.out.println("Open Browser");
		
		Assert.assertEquals(true, true); //Hard assertion
		//right place for hard assert until browser will get open further validating code is useless. 
		
		System.out.println("Enter username");
		System.out.println("Enter password");
		System.out.println("Click on signin button");
		
		Assert.assertEquals(true, true);//Hard assertion
		
		System.out.println("Validate Home Page");
		softAssert.assertEquals(true, false,"Home Page title is missing");//soft assertion
		
		System.out.println("go to deal page");
		System.out.println("Create a deal");
		softAssert.assertEquals(true, false ,"not able to create a deal");//soft assertion
		
		System.out.println("go to contact page");
		System.out.println("Create contact");
		softAssert.assertEquals(true, false,"not able to create contact");//soft assertion
		
		softAssert.assertAll();
		
		
	}
	
	@Test
	public void test2() {
		System.out.println("Logout page");
		softAssert.assertEquals(false, true,"Logout is failed");//TestCase will be passed even if assertion is failed.
		//softAssert.assertAll() method is very important in soft assert.
		softAssert.assertAll();
	}
	
	
	//if we wrote it in @AfterMehtod or @AfterClass, and commenting all assertAll from above TestCase
	//then all the above TestCase will get passed and @AfterMethod/@AfterClass will get failed.so it not preferable.
	/*@AfterClass
	public void tearDown() {
		softAssert.assertAll();
	}
*/
}
