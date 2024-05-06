package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']") private WebElement usernameTextField;	
	@FindBy(xpath="//input[@name='password']") private WebElement passwordTextField;	
	@FindBy(xpath="//button[contains(@class,'btn-dark btn-block')]") private WebElement signInButton;
	@FindBy(xpath="//div[@class='small-box bg-info']//following::p[text()='Admin Users']") private WebElement adminUserTile;
	@FindBy(xpath="//div[@class='small-box bg-info']//following::p[text()='Manage Orders']") private WebElement manageOrderTile;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	
	
	
	public void enterUserNameAndPasswordAndClickonSignInButton(String username, String password)
	{
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		signInButton.click();
	}
	
	
	public boolean verifyUserIsAbleToNavigateToDashboard()
	{
		boolean adminUserTileIsDisplayed=adminUserTile.isDisplayed();
		return adminUserTileIsDisplayed;

	}
	public boolean verifyUserIsNotAbleToNavigateToDashboard()
	{
		boolean alertMessageIsDisplayed=alertMessage.isDisplayed();
		return alertMessageIsDisplayed;
	}
	
}
