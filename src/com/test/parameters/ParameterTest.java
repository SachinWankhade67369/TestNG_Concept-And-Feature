package com.test.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	public static WebDriver driver;

	@Test
	@Parameters({ "Browser", "url", "username" }) // @Parameters annotation is used to mapped the parameters which are
													// declared in testng.xml file.
	public void loginTest(String Browser, String url, String username) {

		if (Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Test WorkSpace\\TestNGConceptAndFeatures\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(url);

		driver.findElement(By.xpath("//a[@id='uh-signin']")).click();

		WebElement username_Element = driver.findElement(By.xpath("//input[contains(@id,'login-username')]"));
		username_Element.clear();
		username_Element.sendKeys(username); // enter username

		driver.findElement(By.xpath("//input[contains(@id,'login-signin')]")).click();// click on next button

		driver.close();
	}

}
