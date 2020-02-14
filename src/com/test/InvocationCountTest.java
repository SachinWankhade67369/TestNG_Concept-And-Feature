package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	//invocationCount is keyword that is used to run single test again and again.
	@Test(invocationCount=10)//it will run same TestCase 10 times. 
	public void sum()
	{
		int a=10;
		int b=20;
		int c= a+b;
		System.out.println("Addition is:"+c);
		
	}

}
