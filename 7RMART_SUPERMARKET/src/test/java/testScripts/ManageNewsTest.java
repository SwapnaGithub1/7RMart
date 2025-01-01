package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage managenws;
	HomePage homepage;

	@Test
	public void verifyAddnNewManageNews() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String news = ExcelUtility.getStringData(0, 0, "Managenews");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage = loginpage.signin();
		managenws = homepage.clickManageNewsMoreInfo();
		managenws.clickNewButon().textField(news).clickSaveButton();
		Assert.assertTrue(managenws.isAlertDisplayed(), Constants.ManageNewsAssert);
	}
}
