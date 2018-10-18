package com.Wallethub_Utilities;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseMethodInitialization 
{
	public static WebDriver driver;
	DataGetterMethod data= new DataGetterMethod();
	
	public WebDriver initializeDriver() throws IOException 
	{		
			System.setProperty("webdriver.chrome.driver", data.getData("DriverPath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
	}
	
	
	public void closeDriver() 
	{		
			
			driver.close();
		
	}
	
	
}
