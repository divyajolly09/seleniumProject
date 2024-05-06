package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageLocationTest extends Base {
	@Test
	public void verifyUserIsAbleToAddLocationInformations()
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String state 	= ExcelUtility.getString(1, 0, "ManageLocationPage");
		String location	= ExcelUtility.getString(1, 1, "ManageLocationPage");
		String deliveryCharge	= ExcelUtility.getInteger(1, 2, "ManageLocationPage");
		boolean isAlertMessageDisplayed;
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		LoginPage loginpage = new LoginPage(driver);
		PageUtility pageutility=new PageUtility(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		managelocationpage.clickOnManageLocationTile().newButtonClick().selectStateDropdown(state).enterLocation(location);
		managelocationpage.enterDeliveryCharge(deliveryCharge).moveToSavebutton();
		pageutility.scrollToLastOfPage();
		managelocationpage.waitForElementToBeVisible().clickOnSaveButton();
		isAlertMessageDisplayed=managelocationpage.verifyAlertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed,"User is not able to create new location");		
	}
	@Test
	public void verifyUserIsAbleToDeleteExistingLocationInformations()
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String location	= ExcelUtility.getString(1, 1, "ManageLocationPage");
		String country	= ExcelUtility.getString(1, 3, "ManageLocationPage");
		boolean isAlertMessageDisplayed;
		LoginPage loginpage = new LoginPage(driver);
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		PageUtility pageutility=new PageUtility(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		managelocationpage.clickOnManageLocationTile().searchLocation(country, location).moveToElement().deleteLocation();
		pageutility.acceptAlert();
		isAlertMessageDisplayed=managelocationpage.verifyAlertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed,"User is not able to delete existing location");
	}
	@Test
	public void verifyNoResultFoundMessageIsDisplayedWhenLocationIsNotAvailableToDelete()
	{
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String location	= ExcelUtility.getString(1, 1, "ManageLocationPage");
		String country	= ExcelUtility.getString(1, 3, "ManageLocationPage");
		LoginPage loginpage = new LoginPage(driver);
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		managelocationpage.clickOnManageLocationTile().searchLocation(country, location);
		boolean noResultFoundTextMessage = managelocationpage.verifyNoResultFoundMessageIsDisplayed();
		assertTrue(noResultFoundTextMessage,"No Result Found message is not displayed");
	}

}
