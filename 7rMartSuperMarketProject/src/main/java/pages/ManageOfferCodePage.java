package pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOfferCodePage 
{
	WebDriver driver;
	
	public ManageOfferCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'admin/list-offercode')]") private WebElement manageOfferCodeTile;
	@FindBy(xpath="//table[contains(@class,'table-bordered')]") private WebElement webTable;
	@FindBy(tagName="tr") private List<WebElement> rows;
	@FindBy(tagName="td") private List<WebElement> columns;
	@FindBy(xpath="//input[@id='main_img']") private WebElement chooseFileButton;
	@FindBy(xpath="//a[contains(@href,'delete')]") private WebElement deleteImageButton;
	@FindBy(xpath="//button[text()='Update']") private WebElement updateImageButton;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") private WebElement offerCodeUpdateAlert;
	@FindBy(xpath="//div[@role='textbox']") private WebElement descriptionField;
	@FindBy(xpath="//a[contains(@href,'comhome')]") private WebElement footerLink;
	@FindBy(xpath="//a[contains(@class,' btn-primary') and contains(@href,'429')]")private WebElement editButton;
	
	
	public ManageOfferCodePage clickOnManageOfferCodeTile()
	{
		manageOfferCodeTile.click();
		return this;
	}
	public int findRowCount()
	{
		PageUtility pageutility = new PageUtility(driver);
		return pageutility.getRowCount(rows);		
	}
	public int findColumnCount()	
	{
		PageUtility pageutility = new PageUtility(driver);
		return pageutility.getColumnCount(columns);		
	}
	public ManageOfferCodePage findPromoCodeInTable(int rowCount, int columnCount, String promoCode) 
	{
		for(int i=1;i<=rowCount;i++)
		{
			String actualrowText = rows.get(i).getText();
			if(actualrowText.contains(promoCode))
			{
				PageUtility pageutility = new PageUtility(driver);
				pageutility.moveToElement(editButton, driver);
				editButton.click();
				break;
			}
						
		}
		return this;
	}
	public ManageOfferCodePage fileUpload(String filePath) throws AWTException
	{
		FileUploadUtility fileUploadUtility = new FileUploadUtility(driver);
		fileUploadUtility.fileUpload(filePath);
		return this;
	}
	public ManageOfferCodePage scrollToElement()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.scrollToElement(deleteImageButton);
		return this;
	}
	public ManageOfferCodePage clickOnChooseFileButton()
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.Click(chooseFileButton, driver);
		return this;
	}
	public ManageOfferCodePage waitForElementToBeClicked()
	{
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeClickable(driver, deleteImageButton);
		return this;
	}
	public ManageOfferCodePage waitForElementToBePresent()
	{
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.waitForElement(driver, chooseFileButton);
		return this;
	}
	public ManageOfferCodePage clickOnUpdateImageButton()
	{
		updateImageButton.click();
		return this;
	}
	public boolean verifyOfferCodeUpdateAlertIsDisplayed()
	{
		return offerCodeUpdateAlert.isDisplayed();
	}
	public ManageOfferCodePage moveToElement() 
	{
		PageUtility pageutility = new PageUtility(driver);
		pageutility.moveToElement(footerLink, driver);
		return this;
	}
}
