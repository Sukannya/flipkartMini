package AddAppliance;

import org.openqa.selenium.By;

public class pageObject
  {
	//others
	public static final By exitLogin = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	public static final By headPicture= By.xpath("//img[@title='Flipkart']");
	public static final By searchBar = By.className("LM6RPg");
	public static final By searchButton = By.className("vh79eN");
    public static final By pincodeBar = By.id("pincodeInputId");
    public static final By checkPin = By.xpath("//span[@class='_2aK_gu']");
    public static final By addTocart = By.xpath("//*[@class='_3oJBMI' and @height='16']");
    
    //Appliances
    public static final By AirCondition = By.xpath("//*[text()='MarQ by Flipkart 1.5 Ton 3 Star Split Inverter AC  - White']");
    public static final By firstAppliance = By.xpath("//div[text()='Mi 4A PRO 80 cm (32) HD Ready LED Smart Android TV With Google Data Saver']");
    public static final By secondAppliance = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[3]/div/div/div/a/div[2]/div[1]/div[1]");
    
    //Price
    public static final By TotalAmount = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[3]/div/span/div/div");
    		
   // public static final By tvAmount = By.cssSelector("div.tnAu1u");
    
    //login credentials
    public static final By userName = By.xpath("//*[@class='_2zrpKA _1dBPDZ']");
    public static final By password = By.xpath("//*[@type='password']");
    public static final By loginButton = By.xpath("(//*[@type= 'submit'])[2]");
}
