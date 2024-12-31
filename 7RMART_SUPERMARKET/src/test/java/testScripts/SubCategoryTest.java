package testScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	SubCategoryPage subcatpage;
	HomePage homepage;

	@Test
	public void VerifytoAddNewSubCategory() throws IOException, AWTException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage = login.signin();
		subcatpage = homepage.subCatmorenfo();
		String input = ExcelUtility.getStringData(0, 0, "SubCategoryPage");
		subcatpage.newButton().selectCategory().InputCategoryName(input).prodImageUpload().saveButton();
		boolean isalertavailable = subcatpage.isAlertDisplayed();
		Assert.assertTrue(isalertavailable, Constants.SubCategoryPage);
	}

	@Test
	public void checktoDeleteItem() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernamevalue);
		login.enterPassword(passwordvalue);
		homepage = login.signin();
		subcatpage = homepage.subCatmorenfo();
		subcatpage.deleteCategory().isalertAccept();
		// add assertion

	}
}
