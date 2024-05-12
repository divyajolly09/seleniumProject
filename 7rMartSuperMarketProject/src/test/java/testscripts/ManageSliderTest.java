package testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.Constants;
import utilities.ExcelUtility;
import utilities.PageUtility;


public class ManageSliderTest extends Base 
{
	@Test
	public void verifyUserIsAbleToAddSliderInformations() 
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String link=ExcelUtility.getString(1, 0, "ManageSliderPage");
		String newImageUpload = Constants.IMAGE;
		boolean alertIsDisplayed;
		LoginPage loginpage = new LoginPage(driver);
		ManageSliderPage managesliderpage=new ManageSliderPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		managesliderpage.clickOnMobileSliderTile().clickOnNewButton().clickOnChooseImageButton(newImageUpload).enterLinkOnLinkTextField(link);
		managesliderpage.moveToSaveButton().clickOnSaveButton();
		alertIsDisplayed=managesliderpage.verifyAlertMessageIsDisplayed();
		assertTrue(alertIsDisplayed,"user is not able to add slider informations");
	}
	@Test
	public void verifyUserIsAbleToDeleteExistingSliderInformation()
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		boolean alertIsDisplayed;
		LoginPage loginpage = new LoginPage(driver);
		PageUtility pageutility= new PageUtility(driver);
		ManageSliderPage managesliderpage=new ManageSliderPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		managesliderpage.clickOnMobileSliderTile().clickOnDeleteButton();
		pageutility.acceptAlert();
		alertIsDisplayed=managesliderpage.verifyAlertMessageIsDisplayed();
		assertTrue(alertIsDisplayed,"user is not able to delete existing slider informations");
		
		
	}
	
	
}
