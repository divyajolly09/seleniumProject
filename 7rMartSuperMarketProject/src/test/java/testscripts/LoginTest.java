package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {
	@Test(groups= {"regression"},retryAnalyzer=retry.Retry.class,description="user is able to login with valid credentials",priority=2)
	public void verifyUserIsAbleToLoginWithValidUsernameAndVaildPassword()
	{
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		boolean adminUserTileIsDisplayed;
		LoginPage loginpage=new LoginPage(driver);		
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);		
		adminUserTileIsDisplayed = loginpage.verifyUserIsAbleToNavigateToDashboard();
		assertTrue(adminUserTileIsDisplayed,"user is not able to login with valid username and valid password");
	}
	@Test(groups= {"regression"},retryAnalyzer=retry.Retry.class,description="user is able to login with invalid credentials",priority=3)
	public void verifyUserIsUnableToLoginWithInvalidUsernameAndVaildPassword()
	{
		String username=ExcelUtility.getString(2, 0, "LoginPage");
		String password=ExcelUtility.getString(2, 1, "LoginPage");
		boolean alertMessageIsDisplayed;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		alertMessageIsDisplayed=loginpage.verifyUserIsNotAbleToNavigateToDashboard();
		assertTrue(alertMessageIsDisplayed,"User is able to login With invalid username And vaild Password");
	}
	@Test(groups= {"smoke"},retryAnalyzer=retry.Retry.class,description="user is able to login with invalid credentials",priority=4)
	public void verifyUserIsUnableToLoginWithvalidUsernameAndInVaildPassword()
	{
		String username=ExcelUtility.getString(3, 0, "LoginPage");
		String password=ExcelUtility.getString(3, 1, "LoginPage");
		boolean alertMessageIsDisplayed;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		alertMessageIsDisplayed=loginpage.verifyUserIsNotAbleToNavigateToDashboard();
		assertTrue(alertMessageIsDisplayed,"User is able to login With valid username And Invaild Password");
	}
	@Test(retryAnalyzer=retry.Retry.class,description="user is able to login with invalid credentials",priority=5)
	public void verifyUserIsUnableToLoginWithInvalidUsernameAndInVaildPassword(String username,String password)
	{
		boolean alertMessageIsDisplayed;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameAndPasswordAndClickonSignInButton(username, password);
		alertMessageIsDisplayed=loginpage.verifyUserIsNotAbleToNavigateToDashboard();
		assertTrue(alertMessageIsDisplayed,"User is able to login With Invalid username And Invaild Password");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() 
	{
		return new Object[][] 
		{ 
			{ 
			ExcelUtility.getString(4, 0, "LoginPage"), ExcelUtility.getString(4, 1, "LoginPage")
			},

		};
	}

}