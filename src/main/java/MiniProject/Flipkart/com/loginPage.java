package MiniProject.Flipkart.com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import AddAppliance.pageObject;

public class loginPage 
{
	WebDriver driver ;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login() throws InterruptedException
	{
		//click cross button
		driver.findElement(pageObject.exitLogin).click();
		Thread.sleep(2000);
	}
	
	public void LoginByCredentials() throws InterruptedException
	{
		driver.findElement(pageObject.userName).sendKeys("457512");
		Thread.sleep(2000);
		driver.findElement(pageObject.password).sendKeys("abc36");
		driver.findElement(pageObject.loginButton).click();
		Thread.sleep(3000);
		
		
		boolean ErrorMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[2]/span")).isDisplayed();
        if(ErrorMsg)
        {
        	Assert.fail();
        }
		
	}
	
	//check if the title is same or not
	public void TitleCheck()
	{
		String expected="flipkart";
		String actual= driver.getTitle();
		boolean verifyTitle = expected.equalsIgnoreCase(actual);
		if(verifyTitle)
		{
			System.out.println("title matches!");
		}
	}
	//check if the heading image is present or not
	public void HeadingImageCheck()
	{
		boolean imagePresent = driver.findElement(pageObject.headPicture).isDisplayed();
		if(imagePresent) //true
		{
			System.out.println("the Image is Visible");
		}
	}
	//check search bar is displayed or not
	public void SearchBarCheck()
	{
		boolean searchBarEnable = driver.findElement(pageObject.searchBar).isDisplayed();
		if(searchBarEnable)
		{
			System.out.println("Search Bar is Working Properly!");
		}
	}
}
