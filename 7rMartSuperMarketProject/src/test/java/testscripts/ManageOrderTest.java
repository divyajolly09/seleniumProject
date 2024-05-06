package testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageOrderPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageOrderTest extends Base 
{
	@Test
	public void verifyUserIsAbleToAssignDeliveryBoy()
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		boolean alertIsDisplayed;
		ManageOrderPage manageOrderPage = new ManageOrderPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		manageOrderPage.clickOnManageOrderTile().assignDeliveryBoyButtonClick().selectValueFromDropDownList().updateButtonClick();
		alertIsDisplayed = manageOrderPage.verifyAlertmessageIsDisplayed();
		assertTrue(alertIsDisplayed,"user is not able to assign delivery boy ");
	}
	@Test
	
	public void verifyUserIsAbleToSearchAnOrderId()
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String orderId  = ExcelUtility.getInteger(1, 0, "ManageOrderPage");
		boolean orderIdValue;
		PageUtility pageutility=new PageUtility(driver);
		ManageOrderPage manageOrderPage = new ManageOrderPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		manageOrderPage.clickOnManageOrderTile().searchButtonClick().enterorderId(orderId);
		pageutility.scrollToBottom();
		manageOrderPage.waitForElementToBeClicked().searchButtonBottomClick();
		orderIdValue=manageOrderPage.verifyOrderIdIsDisplyedInSearchResult();
		assertTrue(orderIdValue,"order id is not displyed in search result");		
	}
}
