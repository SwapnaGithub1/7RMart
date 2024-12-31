package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.FooterTextPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class FooterTextTest extends Base {
	FooterTextPage footertextPage;
	HomePage homepage;

	@Test(groups = { "Regression" })
	public void checkWhetherUppdateFooterTextIsworking() throws IOException {
		FakerUtility fakerutility = new FakerUtility();
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		// String name=ExcelUtility.getStringData(0, 0,"FooterTextPage");
		String Institutionname = fakerutility.getFakeFirstName();
		String mail = ExcelUtility.getStringData(1, 0, "FooterTextPage");
		String no = ExcelUtility.getIntegerData(2, 0, "FooterTextPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage = login.signin();
		footertextPage = homepage.footerText();
		footertextPage.updateButton().enterName(Institutionname).enterMailAddress(mail).enterContactNo(no)
				.saveUpdateButton();
		boolean alert = footertextPage.isAlertPresent();
		Assert.assertTrue(alert, Constants.FooterTextPageAssert);
	}

	@Test
	public void updateButtonisAvailabe() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue);
		login.enterPassword(passwordvalue);
		homepage = login.signin();
		footertextPage = homepage.footerText();
		boolean newbuttonavailable = footertextPage.updateAvailable();
		Assert.assertTrue(newbuttonavailable, Constants.FooterTextupdatebuttonAssert);
	}
}
