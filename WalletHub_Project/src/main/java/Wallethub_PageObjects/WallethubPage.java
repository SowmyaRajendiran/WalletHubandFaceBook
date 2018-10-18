package Wallethub_PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Wallethub_Utilities.DataGetterMethod;


public class WallethubPage {
	

	public WebDriver driver;
	DataGetterMethod data= new DataGetterMethod();
	
	public WallethubPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	By ratingIcon=By.cssSelector("div.wh-rating-notes");
    public WebElement ratingIconProperty()
    {
	      return driver.findElement(ratingIcon);
    }

     By fourthStar=By.xpath("//div[@class=\"wh-rating-choices-holder\"]/a[contains(text(),'4')]");
     public WebElement fourthStarProperty()
     {
	      return driver.findElement(fourthStar);
     }
     
     By fifthStar=By.xpath("//div[@class=\"wh-rating-choices-holder\"]/a[contains(text(),'5')]");
     public WebElement fifthStarProperty()
     {
	      return driver.findElement(fifthStar);
     }
    
     
     /*Method for Validating Title of WalletHub Landing Page*/
     public void IsTitlePresent() throws IOException
  	{
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		//Expected Title Which Should be Displayed
  		String ExpectedTitle= data.getData("InsurancePageTitle");
  		//Get the Actual Title of the Current WebPage
  		String ActualTitle= driver.getTitle();
  		//Compares Whether Actual Title and Expected Title are Equal
  		Assert.assertEquals(ActualTitle, ExpectedTitle);
  	
  	}
     
     
     /*Method for Validating Title of WalletHub Landing Page*/
     public void Is4thStarHighlightedand5thStarClicked() throws InterruptedException 
  	{
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		Actions action= new Actions(driver);
  	    action.moveToElement(ratingIconProperty()).build().perform();
  	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  		action.moveToElement(fourthStarProperty()).build().perform();
  		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  		String value= fourthStarProperty().getCssValue("color");
  		Assert.assertEquals(value, "rgba(0, 0, 238, 1)");
  		Thread.sleep(5000);
  		action.moveToElement(fifthStarProperty()).click().build().perform();
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		
  	}
}
