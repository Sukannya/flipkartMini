package MiniProject.Flipkart.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	public WebDriver driver;
	
	public WebDriver InvokeDriver() throws IOException, InterruptedException
	{
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\SUKANNYA\\eclipse-workspace\\Flipkart.com\\config.properties"));
		Properties prop = new Properties();
		prop.load(fis);
		
		String WebUrl = prop.getProperty("Url");
		String driverType = prop.getProperty("BrowserName");
		
		
		if(driverType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\COGNIZANT\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else
		{
			System.out.println("try chrome!");
		}
		
		
		driver.get(WebUrl);
		return driver;
		
		
	}

}
