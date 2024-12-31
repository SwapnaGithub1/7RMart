package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base {
	@Test
	public void checkAdminLoginisWrking() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue);
		login.enterPassword(passwordvalue);
		login.signin();
		AdminPage admin = new AdminPage(driver);
		admin.adminUser();
		admin.newUser();
		admin.save();
		Assert.assertTrue(admin.isAlertdisplayed(),Constants.AdmnNewUser);
	}

}
