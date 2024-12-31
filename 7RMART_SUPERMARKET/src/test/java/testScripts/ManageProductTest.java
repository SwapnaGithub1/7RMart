package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	ManageProductPage manageprodpage;
	HomePage homepae;

	@Test
	public void checkWhetherAlertisPresentWhenAnyFieldLeftEmpty() throws IOException, InterruptedException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String prod = ExcelUtility.getStringData(0, 0, "ManageProductPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepae = loginpage.signin();
		manageprodpage = homepae.manageproduct();
		manageprodpage.newItem().enterData(prod).saveButton();
		String expctd = ExcelUtility.getStringData(1, 0, "ManageProductPage");
		String actual = manageprodpage.isAlertPresent();
		Assert.assertEquals(actual, expctd, Constants.ManageProdAssert);

	}
}
