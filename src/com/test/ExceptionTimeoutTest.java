package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest {
	
	//timeOut keyword is used to terminate the infinite loop automatically after some interval of time(Milliseconds)
	@Test(timeOut=2000)//ThreadTimeoutException.  
	public void infinitLoopTest() {
		int i=1;
		while(i==1) {
				System.out.println(i);
		}
			
	}

}
