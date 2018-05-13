package com.nbrown.core.framework.sewebdriver;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nbrown.core.framework.TestInitialization.Driver;
import com.nbrown.core.framework.utils.Global;

public class SeWebDriver 
{
	
	public void get(String url)
	{
		try
		{
			Driver.driver.get(url);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public String captureTitle()
	{
		String title = null;
		try
		{
			title = Driver.driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return title;
	}
	
	public String captureUrl()
	{
		String url = null;
		try
		{
			url = Driver.driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return url;
	}
	
	public void waitForElementPresent(String locatorName, String locatorValue)
	{
		try
		{
			WebDriverWait w1 = new WebDriverWait(Driver.driver, Global.syncTime);
			w1.until(ExpectedConditions.presenceOfElementLocated(FindBy.seLocator(locatorName, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getWindowId()
	{
		String winId = null;
		try
		{
			winId = Driver.driver.getWindowHandle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return winId;
	}
	
	public void switchToWindow()
	{
		try
		{
			String id = getWindowId();
			Driver.driver.switchTo().window(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Set<String> getAllWindowId()
	{
		Set<String> allWinId = null;
		try
		{
			allWinId = Driver.driver.getWindowHandles();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allWinId;
	}
	
	public boolean switchToParticularWindow(String expTitle)
	{
		try
		{
			Set<String> allwinId = getAllWindowId();
			for(String winId : allwinId)
			{
				Driver.driver.switchTo().window(winId);
				if(expTitle.equals(captureTitle()))
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public void switchToFrame(String idOrName)
	{
		try
		{
			Driver.driver.switchTo().frame(idOrName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToFrame(int index)
	{
		try
		{
			Driver.driver.switchTo().frame(index);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void switchToFrame(WebElement w1)
	{
		try
		{
			Driver.driver.switchTo().frame(w1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Alert getAlert()
	{
		Alert alt = null;
		try
		{
			alt = Driver.driver.switchTo().alert();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return alt;
	}
	
	public String getAlertText()
	{
		String data = null;
		try
		{
			Alert alt = getAlert();
			data = alt.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean acceptAlert(String altText)
	{
		boolean flag = false;
		try
		{
			if(altText.equals(getAlertText()))
			{
				getAlert().accept();
				flag = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
