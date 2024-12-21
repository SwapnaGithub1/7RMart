package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description = "Verify whether the user is able to login with correct credentials", retryAnalyzer = retry.Retry.class)
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).signin();
		boolean isHomepageavailable = loginpage.isHomePageloaded();
		Assert.assertTrue(isHomepageavailable);
	}

	@Test
	public void verifyLoginwithWrongPassword() throws IOException {
		// String usernamevalue = "admin";
		// String passwordvalue = "swap";
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).signin();
		boolean isalertavailable = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertavailable);

	}

	@Test
	public void verifyLoginwithWrongUsername() throws IOException {
		// String usernamevalue = "admn";
		// String passwordvalue = "admin";
		String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).signin();
		boolean isalertavailable = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertavailable);

	}

	@Test
	public void verifyLoginwithWrongUnameandPwd() throws IOException {
		// String usernamevalue = "admn";
		// String passwordvalue = "admn";
		String usernamevalue = ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).signin();
		boolean isalertavailable = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertavailable, Constants.LoginPageAssert);
	}
}
