package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {

	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[5]")private
	// WebElement more;
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement newbut;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement TField1;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement TField2;
	@FindBy(xpath = "//textarea[1]")
	private WebElement TField3;
	@FindBy(xpath = "//textarea[2]")
	private WebElement TField4;
	@FindBy(xpath = "//input[@id='del_limit']")
	private WebElement TField5;
	@FindBy(xpath = "//button[normalize-space()='Update']")
	private WebElement updatbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageContactPage newButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver, newbut);
		PageUtility pageutility = new PageUtility();
		pageutility.jsExecuterClick(newbut, driver);

		// newbut.click();
		return this;
	}

	public ManageContactPage enterMobNo(String MobileNo) {
		TField1.clear();
		TField1.sendKeys(MobileNo);
		return this;
	}

	public ManageContactPage enterMailAddress(String email) {

		TField2.clear();
		TField2.sendKeys(email);
		return this;
	}

	public ManageContactPage enterPlace(String place) {
		TField3.clear();
		TField3.sendKeys(place);
		return this;
	}

	public ManageContactPage enterTime(String time) {
		TField4.clear();
		TField4.sendKeys(time);
		return this;
	}

	public ManageContactPage enterRate(String rate) {
		TField5.clear();
		TField5.sendKeys(rate);
		return this;
	}

	public ManageContactPage updateButton() {
		PageUtility pu = new PageUtility();
		pu.jsExecuterClick(updatbutton, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
