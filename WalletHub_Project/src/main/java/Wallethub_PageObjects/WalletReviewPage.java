package Wallethub_PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Wallethub_Utilities.DataGetterMethod;

public class WalletReviewPage {
	

	public WebDriver driver;
	DataGetterMethod data= new DataGetterMethod();
	public WalletReviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
    By dropdown=By.cssSelector("div.dropdown-title");
    public WebElement dropdownProperty()
    {
	      return driver.findElement(dropdown);
    }
    
    By healthValue=By.cssSelector("ul.drop-el li:nth-child(2)");
    public WebElement healthValueProperty()
    {
	      return driver.findElement(healthValue);
    }
    
    By reviewTextbox=By.cssSelector("#review-content");
    public WebElement reviewTextboxProperty()
    {
	      return driver.findElement(reviewTextbox);
    }
    
    By submitButton=By.cssSelector("input.btn.blue");
    public WebElement reviewPageSubmitButtonProperty()
    {
	      return driver.findElement(submitButton);
    }
    
    By confirmationMessage=By.cssSelector("div.big-title.small h1 span");
    public WebElement confirmationMessageProperty()
    {
	      return driver.findElement(confirmationMessage);
    }
    
    By overallRating=By.cssSelector("span#overallRating a:nth-child(5)");
    public WebElement overallRatingProperty()
    {
	      return driver.findElement(overallRating);
    }
   
    
    By loginTab=By.xpath("//li/a[contains(text(),'Login')]");
    public WebElement LoginTabProperty()
    {
	      return driver.findElement(loginTab);
    }
    
    By EmailInput=By.cssSelector("#join-light form div div.ng-animate-enabled.basic-trans.enter input");
    public WebElement EmailInputProperty()
    {
	      return driver.findElement(EmailInput);
    }

    By PasswordInput=By.cssSelector("#join-light form div div:nth-child(3) input");
    public WebElement passwordInputProperty()
    {
	      return driver.findElement(PasswordInput);
    }

    By signinButton=By.xpath("//button[@type='button']");
    public WebElement signinButtonProperty()
    {
	      return driver.findElement(signinButton);
    }


    
    /*Method for Selecting Health Value*/
    public void IsHealthValueSelected() throws IOException
 	{
 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 		Assert.assertTrue(dropdownProperty().isDisplayed());
 		dropdownProperty().click();
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		healthValueProperty().click();
 		String valuetext= dropdownProperty().getText();
 		Assert.assertEquals(valuetext, "Health");
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		
 	}

    /*Method for Entering the Review*/
    public void IsReviewSubmitted() throws IOException
 	{
 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 		Assert.assertTrue(reviewTextboxProperty().isDisplayed());
 		reviewTextboxProperty().sendKeys(data.getData("ReviewText"));
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		Actions action= new Actions(driver);
 		action.moveToElement(overallRatingProperty()).click().build().perform();
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		reviewPageSubmitButtonProperty().click();
 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	}
    
   /* Method forValidating Confirmation Page
    public void IsConfirmationPageDisplayed() throws IOException
 	{
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		Assert.assertTrue(confirmationMessageProperty().isDisplayed());
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	}*/
    
    /*Method for Sign In*/
    public void IsSignInButtonClicked() throws IOException
 	{
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		Assert.assertTrue(LoginTabProperty().isDisplayed());
 		LoginTabProperty().click();
 		Assert.assertTrue(EmailInputProperty().isDisplayed());
 		EmailInputProperty().sendKeys(data.getData("Email"));
 		Assert.assertTrue(passwordInputProperty().isDisplayed());
 		passwordInputProperty().sendKeys(data.getData("Password"));
 		Assert.assertTrue(signinButtonProperty().isDisplayed());
 		signinButtonProperty().click();
 		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		
 	}
 		
}
