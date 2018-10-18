package com.Wallethub_Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Wallethub_Utilities.BaseMethodInitialization;
import com.Wallethub_Utilities.DataGetterMethod;
import Wallethub_PageObjects.WalletReviewPage;
import Wallethub_PageObjects.WallethubPage;


public class WallethubTest extends BaseMethodInitialization {
	
	DataGetterMethod data= new DataGetterMethod();
	public static Logger log =LogManager.getLogger(WallethubTest.class);
	public String URL;
		

	
	@Test
	/*
	 * Test for Validating the Review is Entered and Submitted
	 */
	public void Validate_InsurancePage_ReviewSubmission() throws InterruptedException, IOException 
	{
		log.info("User Validates Whether User Selects  Health value form the Dropdow");
		WallethubPage WalletPage= new WallethubPage(driver);
		WalletReviewPage ReviewPage= new WalletReviewPage(driver);
	    //Method to Validate rating
		WalletPage.Is4thStarHighlightedand5thStarClicked();
		log.info("User Validated 4th Start is Hihlighted and then Clicks on Fifth start rating Successfully");
		//Method for Selecting Health Value Form the Dropdown
		ReviewPage.IsHealthValueSelected();
		log.info("User selected Health value form the Dropdown successfully");
		//Method for Entering and Submitting the review
		ReviewPage.IsReviewSubmitted();
		log.info("User Validated Confirmation Page successfully");
		ReviewPage.IsSignInButtonClicked();
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
