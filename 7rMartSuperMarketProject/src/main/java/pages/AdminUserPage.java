package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserPage  {
WebDriver driver;
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath="//a[contains(@href,'/list-admin')]//i[contains(@class,'circle')]")private WebElement adminUserTile;
	@FindBy(xpath="//a[contains(@class,'btn-danger')]//i[@class='fas fa-edit']")private WebElement newButton;
	@FindBy(xpath="//input[@id='username']")private WebElement usernameTextField;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordTextfield;
	@FindBy(xpath="//select[@id='user_type']")private WebElement usertextDropDown;
	@FindBy(xpath="//button[@name='Create']")private WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")private WebElement alertMessage;


	
	
	
	public AdminUserPage adminUserTileclick()
	{		
		adminUserTile.click();
		return this;
	}
	public AdminUserPage newButtonClick()
	{
		newButton.click();
		return this;
		
	}
	public AdminUserPage enterValidAdminDetails(String adminusername, String adminpassword, String usertextDropdownValue)
	{
		PageUtility pageutility=new PageUtility(driver);
		usernameTextField.sendKeys(adminusername);
		passwordTextfield.sendKeys(adminpassword);
		pageutility.selectDropdownValue(usertextDropDown, usertextDropdownValue);
		return this;		
	}
	public AdminUserPage clickonsavebutton()
	{
		saveButton.click();
		return this;
	}
	public String alertMessageIsDisplayed()
	{
		String alertText = alertMessage.getText();
		String actualAlertText  = alertText.substring(8, 34);
		return actualAlertText;
	}
}