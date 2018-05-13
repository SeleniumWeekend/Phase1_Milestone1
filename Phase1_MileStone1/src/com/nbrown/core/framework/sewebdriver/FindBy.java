package com.nbrown.core.framework.sewebdriver;

import org.openqa.selenium.By;

public class FindBy 
{
	public static By seLocator(String locatorName, String locatorValue)
	{
		By by = null;
		switch(locatorName)
		{
			case "id":
				by = By.id(locatorValue);
				return by;
				
			case "name":
				by = By.name(locatorValue);
				return by;
				
			case "xpath":
				by = By.xpath(locatorValue);
				return by;
				
			case "css_selector":
				by = By.cssSelector(locatorValue);
				return by;
				
			case "link_text":
				by = By.linkText(locatorValue);
				return by;
				
			case "partial_linktext":
				by = By.partialLinkText(locatorValue);
				return by;
				
			case "class_name":
				by = By.className(locatorValue);	
				return by;
				
			case "tagName":
				by = By.tagName(locatorValue);	
				return by;
		}
		return by;
		
	}

}
