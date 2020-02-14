package com.test;

import org.testng.annotations.Test;

public class ExpectedExceptionFeature {

	//Ques-- Without try catch block how will handle the exception in selenium?
	@Test(expectedExceptions = NumberFormatException.class)
	public void exceptionTest()
	{
		//NumberForamtException
		String s= "100A";
		int a=Integer.parseInt(s);
		System.out.println(a);
		
	}
	
	@Test(expectedExceptions=ArithmeticException.class)
			//,expectedExceptionsMessageRegExp="Arithmatic exception is occured.")
	public void arithExceptionTest() throws Exception{
		int a=1/0;
		System.out.println(a);
	}
}
