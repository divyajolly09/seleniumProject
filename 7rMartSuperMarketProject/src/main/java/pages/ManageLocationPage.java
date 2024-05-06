package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageLocationPage
{
WebDriver driver;
	
	public ManageLocationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']//p")private WebElement manageLocationTile;
	@FindBy(xpath="//a[contains(@class,' btn-danger')]//i[@class='fas fa-edit']")private WebElement NewButton;
	@FindBy(xpath="//select[@name='state_id']")private WebElement stateValue;
	@FindBy(xpath="//input[@id='location']")private WebElement location ;
	@FindBy(xpath="//input[@id='delivery']")private WebElement deliveryCharge;
	@FindBy(xpath="//button[@name='create']")private WebElement saveButton ;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement alertMessage ;
	@FindBy(xpath="//div[@class='col-sm-12']//a[contains(@class,'btn-primary')]") private WebElement searchButton;
	@FindBy(xpath="//select[@id='country_id']") private WebElement countryDropdown;
	@FindBy(xpath="//button[contains(@class,'lign-center')]") private WebElement searchButtonBottom;
	@FindBy(xpath="//a[contains(@href,'Location/delete')]") private WebElement deleteButton;
	@FindBy(xpath="//span[@id='res']") private WebElement noResultFoundTextMessage;
	
	public ManageLocationPage clickOnManageLocationTile()
	{
		manageLocationTile.click();
		return this;
	}
	public ManageLocationPage newButtonClick()
	{
		NewButton.click();
		return this;
	}
	public ManageLocationPage selectStateDropdown(String state)
	{
		PageUtility pageutility=new PageUtility(driver);
		pageutility.selectDropdownValue(stateValue, state);
		return this;
	}
	public ManageLocationPage enterLocation(String locationValue)
	{
		location.sendKeys(locationValue);
		return this;
	}
	public ManageLocationPage enterDeliveryCharge(String deliveryChargeValue)
	{
		deliveryCharge.sendKeys(deliveryChargeValue);
		return this;
	}
	public ManageLocationPage clickOnSaveButton() 
	{
		saveButton.click();	
		return this;
	}
	public boolean verifyAlertMessageIsDisplayed()
	{
		return alertMessage.isDisplayed();
	}
	public ManageLocationPage waitForElementToBeVisible()
	{
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForElement(driver, saveButton);
		return this;
	}
	public ManageLocationPage moveToSavebutton() 
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.moveToElement(saveButton, driver);
		return this;
	}
	public ManageLocationPage searchLocation(String country, String locationValue) 
	{
		PageUtility pageutility=new PageUtility(driver);
		searchButton.click();
		pageutility.selectDropdownValue(countryDropdown, country);
		location.sendKeys(locationValue);		
		searchButtonBottom.click();		
		return this;
	}
	public ManageLocationPage deleteLocation()
	{
		deleteButton.click();
		return this;
	}
	public ManageLocationPage moveToElement()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.moveToElement(deleteButton, driver);
		return this;
	}
	public boolean verifyNoResultFoundMessageIsDisplayed()
	{
		return noResultFoundTextMessage.isDisplayed();
		
	}
}
	
