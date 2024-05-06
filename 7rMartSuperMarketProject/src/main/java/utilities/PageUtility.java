package utilities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {
	
	public WebDriver driver;
	public PageUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}
	public void moveToElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void contextClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void Click(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();
	}
	public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void dragAndDrop(WebElement elementToBeDragged, WebElement elementToBePlaced, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(elementToBeDragged,elementToBePlaced).perform();
	}
	public void selectDropdownValue(WebElement dropDown,String dropDownvalue)
	{
		Select selectsingledropdownlist=new Select(dropDown);
		selectsingledropdownlist.selectByVisibleText(dropDownvalue);
	}
	public void selectDropdownValueUsingSelectByValue(WebElement dropDown,String dropDownvalue)
	{
		Select selectsingledropdownlist=new Select(dropDown);
		selectsingledropdownlist.selectByValue(dropDownvalue);
	}
	public void selectDropdownValueUsingSelectByIndex(WebElement dropDown,String dropDownvalue)
	{
		Select selectsingledropdownlist=new Select(dropDown);
		selectsingledropdownlist.selectByIndex(0);
	}
	public void scrollToBottom()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1750)", "");
	}
	public void scrollToLastOfPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void waitForElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void acceptAlert() 
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert() 
	{
		driver.switchTo().alert().dismiss();
	}
	public String alertUsingGetText()
	{
		return driver.switchTo().alert().getText();
	}
	public void alertUsingSendKeys(String value)
	{
		driver.switchTo().alert().sendKeys(value);;
	}
	public int getRowCount(List<WebElement> rows)
	{
		return rows.size();		
	}
	public int getColumnCount(List<WebElement> columns)
	{
		return columns.size();		
	}

}
