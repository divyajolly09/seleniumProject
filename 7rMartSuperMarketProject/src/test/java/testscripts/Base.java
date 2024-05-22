package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {
	WebDriver driver;
	public ScreenShotUtility scrshot;
	public Properties prop;
	FileInputStream fs;
	
	@BeforeMethod(alwaysRun=true)	
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(Constants.CONFIGFILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
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
		driver.get(prop.getProperty("url"));
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.implicitWait(driver);
		driver.manage().window().maximize();		
	}
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
