package com.FaceBook_Utilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseMethodInitialization 
{
	public static WebDriver driver;
	DataGetterMethod data= new DataGetterMethod();
	
	public WebDriver initializeDriver() throws IOException 
	{		
			System.setProperty("webdriver.gecko.driver", data.getData("DriverPath"));
			driver = new FirefoxDriver();
			return driver;
	}
	
	
	public void closeDriver() 
	{		
			
			driver.close();
		
	}
	
	
}

