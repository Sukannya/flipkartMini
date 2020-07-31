package MiniProject.Flipkart.com;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import AddAppliance.AddAppliances;

public class FlipkartTestClass
{
	 WebDriver driver;
	 AddAppliances add;
	 Logger log = Logger.getLogger("FlipkartTestClass");
	 
	@BeforeSuite(groups="smoke")
	public void driverInvokeTest() throws IOException, InterruptedException
	{
		
    	DriverSetup drv = new DriverSetup();
    	log.info("invoking the driver..............");
		driver = drv.InvokeDriver();
	}
	
    @Test(priority=0, groups="smoke")
    public void loginTest() throws InterruptedException
    {
    	loginPage pg = new loginPage(driver);
    	pg.login();
    	log.info("Use Flipkart Without Login.....");
    }
    
	@Test(priority=1, groups="smoke")
	public void titileTest()
	{
		loginPage pg1 = new loginPage(driver);
		log.info("Verifying the Title -- Please Wait!");
    	pg1.TitleCheck();
	}
	
	@Test(priority = 2, groups="smoke")
	public void searchBarTest()
	{
		loginPage pg3 = new loginPage(driver);
		log.info("Checking The Search Bar -- Wait Until it finishes!");
		pg3.SearchBarCheck();
	}
	

	@Test(priority = 3, groups="smoke")
	public void HeadImageTest()
	{
		loginPage pg4 = new loginPage(driver);
		log.info("Checking the Image on Top. Plese Wait!");
		pg4.HeadingImageCheck();
	}
	
    @Test(priority = 4, groups = "regression")
    public void searchTVtest() throws InterruptedException, IOException 
    {
    	log.info("Search For Your Favourite Home Appliance!");
    	add = new AddAppliances(driver);
    	add.searchTv();
    }
    
    @Test(priority = 5,groups = "regression")
    public void addFirstTvTest() throws InterruptedException, IOException
    {
    	log.info("Adding Item to the Cart.....");    
    	add.addFirstAppliance();
    }
    
   @Test(priority = 6, groups = "regression")
   public void addSecondTvTest() throws InterruptedException
   {
	   log.info("Adding another item to the Cart.....");
	   add.AddSecondappliance();
   }
    
    @Test(priority = 7, groups = "regression")
    public void displayFirstAmount() throws IOException
    {
    	log.info("The total Amount of two item is added! check excel sheet for further info!");
    	add.DisplayAmount();
    }
    
    @Test(priority = 8, groups = "regression")
    public void searchAcTest() throws InterruptedException, IOException 
    {
    	log.info("Search For Your Favourite Home Appliance!");
        add.searchAC();
    }
    
    @Test(priority = 9, groups = "regression")
    public void addACtest() throws InterruptedException, IOException
    {
    	log.info("Adding another item to the Cart.....");
        add.AddThirdAppliance();
    }
    
    @Test(priority = 11, groups = "regression")
    public void ScreenshotTest() throws IOException
    {
    	log.info("Screenshot Taken!");
    	add.TakeScreenshot();
   }
    
   @Test(priority = 10, groups = "regression")
    public void DisplayTotalamount() throws IOException
    {
    	log.info("The Total Amount of two item is added! check excel sheet for further info!");
    	add.displayTotalAmount();
    }
    
   @AfterSuite
   public void closebrowser()
   {
	   driver.quit();
   }
    
}


