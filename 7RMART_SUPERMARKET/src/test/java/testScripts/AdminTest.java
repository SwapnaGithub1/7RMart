package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base {
	AdminPage adminpage;
	HomePage homepage;

	@Test
	public void checkwhetherAddingNewUserTOAdminLoginIsWorking() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage = login.signin();
		adminpage = homepage.adminMoreinfo();
		adminpage.adminUser().newUserName().newPassword().saveButton();
		Assert.assertTrue(adminpage.isAlertDisplayed(), Constants.AdmnNewUser);
	}

}
