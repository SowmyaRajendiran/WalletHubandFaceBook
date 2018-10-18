package com.Wallethub_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class DataGetterMethod 
{
	public static WebDriver driver;
	public String getData(String Value) throws IOException
	{
		Properties property= new Properties();
		FileInputStream fileinput= new FileInputStream("C:\\WalletHub_Project\\src\\main\\java\\com\\Wallethub_Utilities\\data.properties");
		property.load(fileinput);
		return property.getProperty(Value);
	}

}
