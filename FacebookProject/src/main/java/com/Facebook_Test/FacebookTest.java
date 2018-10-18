package com.Facebook_Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FaceBook_Utilities.BaseMethodInitialization;
import com.FaceBook_Utilities.DataGetterMethod;
import com.Facebook_PageObjects.FaceBookPage;


public class FacebookTest extends BaseMethodInitialization  {
	
	DataGetterMethod data= new DataGetterMethod();
	public static Logger log =LogManager.getLogger(FacebookTest.class);
	public String URL;
		
	
	@Test
	/*
	 * Test for Validating the Amazon Landing Page Title
	 */
	public void Validate_FaceBookLandingPage_SignIn() throws IOException 
	{
		log.info("User Sign In to FaceBook Account");
		FaceBookPage FBPage= new FaceBookPage(driver);
	    //Method for Validating SignIn
		FBPage.SignIn();
		log.info("User is Logged In Successfully");
	
	}


	@BeforeTest
	public void initialize() throws IOException
	{	
		 driver =initializeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(data.getData("BaseURL"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void endTest() 
	{	
		 closeDriver();
	}
}
