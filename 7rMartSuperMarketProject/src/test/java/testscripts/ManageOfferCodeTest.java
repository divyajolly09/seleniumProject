package testscripts;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageOfferCodePage;
import utilities.ExcelUtility;
import utilities.Constants;
import utilities.PageUtility;

public class ManageOfferCodeTest extends Base 
{
	@Test(retryAnalyzer=retry.Retry.class,description="verify User IS Able To Upload PromoCode In Existing OfferCode",priority=10)
	public void verifyUserISAbleToUploadPromoCodeInExistingOfferCode() throws InterruptedException, AWTException
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String promoCode = ExcelUtility.getString(1, 0, "ManageOfferCodePage");
		String newImageUpload = Constants.OFFERCODEIMAGE;
		boolean isOffercodeAlertDisplayed;
		ManageOfferCodePage manageOfferCodePage = new ManageOfferCodePage(driver);
		LoginPage loginpage = new LoginPage(driver);
		PageUtility pageutility=new PageUtility(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		manageOfferCodePage.clickOnManageOfferCodeTile();
		int rowCount = manageOfferCodePage.findRowCount();
		int columnCount = manageOfferCodePage.findColumnCount();
		manageOfferCodePage.findPromoCodeInTable(rowCount,columnCount, promoCode);
		pageutility.scrollToLastOfPage();
		manageOfferCodePage.clickOnChooseFileButton().fileUpload(newImageUpload).moveToElement().clickOnUpdateImageButton();
		isOffercodeAlertDisplayed = manageOfferCodePage.verifyOfferCodeUpdateAlertIsDisplayed();
		assertTrue(isOffercodeAlertDisplayed, "User is not able to update offer Code");
	}
}
