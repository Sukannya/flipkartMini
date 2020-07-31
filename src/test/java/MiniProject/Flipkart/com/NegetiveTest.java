package MiniProject.Flipkart.com;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import AddAppliance.AddAppliances;

public class NegetiveTest 
{
	 DriverSetup drv;
	 WebDriver driver;
   
	 @BeforeSuite
	 public void driverInvokeTest() throws IOException, InterruptedException
	 {
	    drv = new DriverSetup();
		driver = drv.InvokeDriver();
	 }
	 
	 @Test(priority = 1)
	 public void LoginTest() throws InterruptedException
	 {
		 loginPage pg = new loginPage(driver);
		 pg.LoginByCredentials();
	 }
	 
	 @Test(priority = 2)
	 public void validlogin() throws InterruptedException
	 {
		 loginPage pg2 = new loginPage(driver);
		 pg2.login();
	 }
    
	 @Test(priority = 3)
	 public void searchItemTest()
	 {
	  AddAppliances ad = new AddAppliances(driver);
	  ad.searchWrong();
	 }
	 
	 @AfterSuite
	 public void CloseBrowser()
	 {
		 driver.close();
	 }
}

