package testscripts;


import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {


	@Test(retryAnalyzer=retry.Retry.class,description="user is able to add admin user details",priority=1)
	public void userIsAbleToAddAdminUserDetails()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String adminusername=ExcelUtility.getString(1, 0, "AdminUserPage");
		String adminpassword=ExcelUtility.getString(1, 1, "AdminUserPage");
		String usertextDropdown=ExcelUtility.getString(1, 2, "AdminUserPage");
		String expectedAlertText =ExcelUtility.getString(1, 3, "AdminUserPage");
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.adminUserTileclick().newButtonClick().enterValidAdminDetails(adminusername,adminpassword,usertextDropdown).clickonsavebutton();
		String alertText=adminuserpage.alertMessageIsDisplayed();
		assertEquals(expectedAlertText,alertText, "User is not able to Add new admin details");
	}	
}
