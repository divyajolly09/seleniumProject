package testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.WaitUtility;

public class Base {
	WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)	
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			throw new Exception("browser is not correct");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.implicitWait(driver);
		driver.manage().window().maximize();		
	}
	@AfterMethod(alwaysRun=true)
	public void browserQuit()
	{
		driver.quit();
	}
}
