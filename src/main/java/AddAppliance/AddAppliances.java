package AddAppliance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Excel.ReadingExcel;
import Excel.WritingExcel;

public class AddAppliances {
	
	WebDriver driver ;
	ReadingExcel read;
	
	public AddAppliances(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	public void searchTv() throws InterruptedException, IOException
	{
		read = new ReadingExcel();
		String TV=read.readData(1,0);
		//search TV from SearchBar
		driver.findElement(pageObject.searchBar).sendKeys(TV);
		Thread.sleep(2000);
		//click search button
	    driver.findElement(pageObject.searchButton).click();
	    Thread.sleep(2000);
	}
	
	//search for a wrong item
	public void searchWrong()
	{
		driver.findElement(pageObject.searchBar).sendKeys("1237458");
		driver.findElement(By.id("dress")).click();
		
	}
	
	//searching for a tv
	public void addFirstAppliance() throws InterruptedException, IOException
	{
		//selecting first TeleVision
		driver.findElement(pageObject.firstAppliance).click();
		//window handle
		Set<String> window1 = driver.getWindowHandles();
		ArrayList<String> tab1 = new ArrayList<String>(window1);
		driver.switchTo().window(tab1.get(1));
		//entering pin code
		driver.findElement(pageObject.pincodeBar).sendKeys("711104");
		//click check PinCode
		driver.findElement(pageObject.checkPin).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//add to cart
		driver.findElement(pageObject.addTocart).click();
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(tab1.get(0));
	}
	
	//second TV 
	public void AddSecondappliance() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//selecting second TeleVision
	    driver.findElement(pageObject.secondAppliance).click();
	    //window handle
	    Set <String> window2= driver.getWindowHandles();
	    ArrayList<String> tab2= new ArrayList<String>(window2);
	    driver.switchTo().window(tab2.get(1));
	    Thread.sleep(5000);
	    //add to cart
	    driver.findElement(pageObject.addTocart).click();
	    Thread.sleep(4000);
	    driver.switchTo().window(tab2.get(1));
	}
	public void DisplayAmount() throws IOException
	{
		//display amount
		String amount = driver.findElement(pageObject.TotalAmount).getText();
		System.out.println(amount);
		WritingExcel write = new WritingExcel();
		write.WriteData(amount,0);
	}
	
	//search for an AC
	public void searchAC() throws InterruptedException, IOException
	{
		read = new ReadingExcel();
		String AC = read.readData(1,1);
		//search for AC
		driver.findElement(pageObject.searchBar).sendKeys(AC);
		driver.findElement(pageObject.searchButton).click();
		Thread.sleep(2000);
	}
	
	public void AddThirdAppliance() throws InterruptedException
	{
		//selecting 3rd AC
		driver.findElement(pageObject.AirCondition).click();
		//window handle
		Set <String> window3= driver.getWindowHandles();
		ArrayList<String> tab3= new ArrayList<String>(window3);
		driver.switchTo().window(tab3.get(2));
		Thread.sleep(3000);
		driver.findElement(pageObject.addTocart).click();
		Thread.sleep(3000);;
		//String finalPrice = driver.findElement(pageObject.TotalAmount).getText();
		//System.out.println(finalPrice);
		
	}
	
	public void displayTotalAmount() throws IOException
	{	Set <String> window3= driver.getWindowHandles();
		ArrayList<String> tab3= new ArrayList<String>(window3);
		driver.switchTo().window(tab3.get(2));
		String finalPrice = driver.findElement(pageObject.TotalAmount).getText();
		System.out.println(finalPrice);
		WritingExcel write = new WritingExcel();
	    write.WriteData(finalPrice,1);
	}
	public  void TakeScreenshot() throws IOException
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    TakesScreenshot ScrObj = (TakesScreenshot) driver;
		File CaptureImg = ScrObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(CaptureImg, new File("./Screenshots/"+"FinalAmount.jpg"));
	}
}
