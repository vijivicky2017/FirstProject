package org.cts.git;

import java.util.Date;

import org.cts.Baseclass.LibGlobal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A extends LibGlobal {

	@BeforeClass
	public static  void startTime() {
		Date d=new Date();
		System.out.println("start time and date="+d);
	}
	@Before
	public void launch() {
		browserLaunch();
		toLaunchUrl("https://www.redbus.in/");
		toMaximize();
	}
	@Test
	public void tc1() {
		
		WebElement p1 = driver.findElement(By.id("sign-in-icon-down"));
	    p1.click();
	    WebElement p2 = driver.findElement(By.id("signInLink"));
	    p2.click();
//	    driver.switchTo().frame("mobileNoInp");
//	    WebElement p3 = driver.findElement(By.id("mobileNoInp"));
//	    p3.sendKeys("9003041054");
	//	
		
	}
	@After
	public void endBrowser() {
		toQuit();
	}
	@AfterClass
	public static void endTime() {
		Date d=new Date();
		System.out.println("endTime and date ="+d);
	}
	}
		
		

