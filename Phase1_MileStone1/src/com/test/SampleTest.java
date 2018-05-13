package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nbrown.core.framework.TestInitialization.Driver;
import com.nbrown.core.framework.datalayer.Excel;
import com.nbrown.core.framework.sewebdriver.FindBy;
import com.nbrown.core.framework.sewebdriver.SeWebDriver;

public class SampleTest
{
	SeWebDriver sdriver = null;
	public SampleTest()
	{
		sdriver = new SeWebDriver();
	}
	
	@BeforeClass
	public void init()
	{
		new SampleTest();
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		WebDriver driver = Driver.getDriver();
		String url = "https://www.naukri.com/";
		driver.get(url);
		driver.findElement(FindBy.seLocator("xpath", "//div[text()='Recruiters']")).click();
		Thread.sleep(5000);
		String titel = "HR Manager - HR Executive - HR Recruiter Consultants - Naukri.com";
		boolean b = sdriver.switchToParticularWindow(titel);
		if(b)
		{
			driver.findElement(FindBy.seLocator("xpath", "//div[text()='Companies']")).click();
		}
	}
}
