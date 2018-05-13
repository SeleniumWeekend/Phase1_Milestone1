package com.nbrown.core.framework.TestInitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.nbrown.core.framework.utils.Global;

public class Driver
{
	public static WebDriver driver= null;
	public static WebDriver getDriver()
	{
		String browser = Global.browserName;
		
		switch(browser)
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Global.chromeServer);
				driver = new ChromeDriver();
				return driver;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Global.ffServer);
				driver = new FirefoxDriver();
				return driver;
				
			case "ie":
				System.setProperty("webdriver.ie.driver", Global.ieServer);
				driver = new InternetExplorerDriver();
				return driver;
		}
		
		return driver;
	}
}
