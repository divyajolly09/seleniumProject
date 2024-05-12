package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageSliderPage
{
	WebDriver driver;
		
		public ManageSliderPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);

		}
		@FindBy(xpath="//div[contains(@class,'bg-info')]//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']")private WebElement mobliesliderTile;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newButton;	
		@FindBy(xpath="//input[@id='main_img']")private WebElement chooseFileButton;	
		@FindBy(xpath="//input[@id='link']") private WebElement linkTextField;
		@FindBy(xpath="//button[@name='create']") private WebElement saveButton;
		@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
		@FindBy(xpath="//table[contains(@class,'table-bordered')]//tr[1]//td[4]//a[contains(@href,'delete')]")private WebElement deletebutton;
		

		public ManageSliderPage clickOnMobileSliderTile()
		{
			mobliesliderTile.click();
			return this;
		}
		public ManageSliderPage clickOnNewButton()
		{
			newButton.click();
			return this;
		}

		public ManageSliderPage clickOnChooseImageButton(String newImageUpload)
		{
			FileUploadUtility fileuploadutility=new FileUploadUtility(driver); 
			fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, newImageUpload);
			return this;
		}
		public ManageSliderPage enterLinkOnLinkTextField(String link) 
		{
			linkTextField.sendKeys(link);
			return this;
		}
		public ManageSliderPage clickOnSaveButton()
		{
			saveButton.click();
			return this;
		}
		
		public ManageSliderPage moveToSaveButton() 
		{
			PageUtility pageutility= new PageUtility(driver);
			pageutility.moveToElement(saveButton, driver);
			return this;
			
		}
		public boolean verifyAlertMessageIsDisplayed() 
		{
			
			return alertMessage.isDisplayed() ;
		}
		public ManageSliderPage clickOnDeleteButton() 
		{
			deletebutton.click();
			return this;
			
		}
		
}