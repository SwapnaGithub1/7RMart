package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {

	HomePage homepage;
	LoginPage login;

	@Test
	public void checkWhetherLogoutisWorking() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue);
		login.enterPassword(passwordvalue);
		homepage = login.signin();
		homepage.clickHomepageMoreInfo().clickLogoutButton();
		Assert.assertTrue(homepage.islogoutDisplayed(),Constants.LogotnotWrking);
	}

}
