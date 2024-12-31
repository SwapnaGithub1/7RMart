package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constants;
import pages.LoginPage;
import pages.HomePage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	ManageContactPage managecontactpage;
	HomePage homePage;

	@Test
	public void checkWhetherManageContactUpdateisWorking() throws IOException {

		LoginPage loginpage = new LoginPage(driver);
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		String Mno = ExcelUtility.getIntegerData(0, 0, "ManageContactPage");
		String mail = ExcelUtility.getStringData(1, 0, "ManageContactPage");
		String place = ExcelUtility.getStringData(2, 0, "ManageContactPage");
		String time = ExcelUtility.getStringData(3, 0, "ManageContactPage");
		String rate = ExcelUtility.getIntegerData(4, 0, "ManageContactPage");
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homePage = loginpage.signin();
		managecontactpage = homePage.manageContact();
		managecontactpage.newButton().enterMail(mail).enterMobno(Mno).enterPlace(place).enterTime(time).enterRate(rate)
				.update();

		Assert.assertTrue(managecontactpage.isalertdiplayed(), Constants.ManageContactAssert);

	}
}
