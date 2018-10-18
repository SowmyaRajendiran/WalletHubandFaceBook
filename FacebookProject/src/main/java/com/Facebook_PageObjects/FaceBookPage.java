package com.Facebook_PageObjects;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.FaceBook_Utilities.DataGetterMethod;

public class FaceBookPage {

	public WebDriver driver;
	DataGetterMethod data= new DataGetterMethod();
	public FaceBookPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

     By emailInputField=By.cssSelector("#email");
     public WebElement emailInputFieldProperty()
     {
	      return driver.findElement(emailInputField);
     }
     
     By passwordInputField=By.cssSelector("#pass");
     public WebElement passwordInputFieldProperty()
     {
	      return driver.findElement(passwordInputField);
     }
     
     By submitButton=By.cssSelector("#loginbutton");
     public WebElement submitButtonProperty()
     {
	      return driver.findElement(submitButton);
     }
    
    
     /*Method for Validating Title of FaceBook Landing Page*/
     public void IsTitlePresent() throws IOException
  	{
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		//Expected Title Which Should be Displayed
  		String ExpectedTitle= data.getData("FBLandingPageTitle");
  		//Get the Actual Title of the Current WebPage
  		String ActualTitle= driver.getTitle();
  		//Compares Whether Actual Title and Expected Title are Equal
  		Assert.assertEquals(ActualTitle, ExpectedTitle);
  	
  	}
     
     /*Method for Validating Title of FaceBook Landing Page*/
     public void SignIn() throws IOException
  	{
    	IsTitlePresent();
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		Assert.assertTrue(emailInputFieldProperty().isDisplayed());
  		emailInputFieldProperty().sendKeys(data.getData("SignInUsername"));
  		Assert.assertTrue(passwordInputFieldProperty().isDisplayed());
  		passwordInputFieldProperty().sendKeys(data.getData("SignInPassword"));
  		Assert.assertTrue(submitButtonProperty().isDisplayed());
  		submitButtonProperty().click();
  	}
   
    
}
