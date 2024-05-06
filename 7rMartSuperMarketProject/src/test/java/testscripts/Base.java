package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.WaitUtility;

public class Base {
	WebDriver driver;
	@BeforeMethod	
	public void initializeBrowser()
	{
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.implicitWait(driver);
		driver.manage().window().maximize();		
	}
	@AfterMethod
	public void browserQuit()
	{
		driver.quit();
	}
}
