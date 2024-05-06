package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOrderPage  {

WebDriver driver;
	
	public ManageOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-target='#mymodal3118']") private WebElement assignDeliveryBoy;
	@FindBy(xpath="//a[contains(@class,'nav-link')]//i[contains(@class,'fa-shopping-basket')]") private WebElement manageOrderTile;
	@FindBy(xpath="//div[@id='mymodal3118']//select") private WebElement deliveryBoyDropDown;
	@FindBy(xpath="//div[@id='mymodal3118']//button[@name='assign_del']") private WebElement updateButton;
	@FindBy(xpath="//button[@data-dismiss='alert']") private WebElement alertAssignDeliveryBoy;
	@FindBy(xpath="//a[contains(@class,'btn-rounded') and text()=' Search']") private WebElement searchButton;
	@FindBy(xpath="//input[@placeholder='Order Id']") private WebElement orderIdTextField;
	@FindBy(xpath="//button[@name=\"Search\"]") private WebElement searchButtonBottom;
	@FindBy(xpath="//table[contains(@class,'table-bordered')]//tbody//td[1]") private WebElement orderIdValue;
	
	
	
	public ManageOrderPage clickOnManageOrderTile()
	{
		manageOrderTile.click();
		return this;
	}
	public ManageOrderPage assignDeliveryBoyButtonClick()
	{
		assignDeliveryBoy.click();
		return this;
	}
	public  ManageOrderPage selectValueFromDropDownList()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.selectDropdownValue(deliveryBoyDropDown, "sumesh");
		return this;
		
	}
	public  ManageOrderPage updateButtonClick()
	{
		updateButton.click();
		return this;
		
	}
	public boolean verifyAlertmessageIsDisplayed()
	{
		return alertAssignDeliveryBoy.isDisplayed();
	}
	public ManageOrderPage searchButtonClick()
	{
		searchButton.click();
		return this;
	}
	public ManageOrderPage enterorderId(String orderId)
	{
		orderIdTextField.sendKeys(orderId);
		return this;
		
	}
	public ManageOrderPage searchButtonBottomClick()
	{
		searchButtonBottom.click();
		return this;
	}
	public boolean verifyOrderIdIsDisplyedInSearchResult() 
	{
		return orderIdValue.isDisplayed();
	}
	public ManageOrderPage waitForElementToBeClicked()
	{
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeClickable(driver, searchButtonBottom);
		return this;
	}
		
}
