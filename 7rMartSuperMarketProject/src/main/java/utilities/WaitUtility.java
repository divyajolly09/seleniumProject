package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT= 20;
	public static final long EXPLICIT_WAIT = 50;
	public WebDriver driver;
	public WaitUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		
	}
	public void waitForElement(WebDriver driver, WebElement target)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.visibilityOf(target));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement target)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public void waitForElementToBeSelected(WebDriver driver, WebElement target)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(target));
	}
	public void waitForElementToBePresent(WebDriver driver, WebElement target)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) target));
	}
	public void waitForAlertIsPresent(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent ());
	}
	public void frameToBeAvailableAndSwitchInToIt(WebDriver driver, WebElement target) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By) target));
	}
	public void fluentwait(WebDriver driver, WebElement target)
	{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)	
	        .withTimeout(Duration.ofSeconds(30))
	        .pollingEvery(Duration.ofSeconds(5))
	        .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.visibilityOf(target));
	}
	public void fluentwaitElementToBeClickable(WebDriver driver, WebElement target)
	{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)	
	        .withTimeout(Duration.ofSeconds(30))
	        .pollingEvery(Duration.ofSeconds(5))
	        .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public void fluentwaitElementAlertIsPresent(WebDriver driver)
	{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)	
	        .withTimeout(Duration.ofSeconds(30))
	        .pollingEvery(Duration.ofSeconds(5))
	        .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.alertIsPresent());
	}
	public void fluentwaitframeToBeAvailableAndSwitchInToIt(WebDriver driver, WebElement target)
	{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)	
	        .withTimeout(Duration.ofSeconds(30))
	        .pollingEvery(Duration.ofSeconds(5))
	        .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By) target));
	}
	
}
	
