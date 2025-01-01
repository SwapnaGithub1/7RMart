package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage {
	WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'][normalize-space()='More info'])[1]")
	private WebElement admnbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newBut;
	@FindBy(xpath = "(//input[@id='username'])[1]")
	private WebElement field1;
	@FindBy(xpath = "(//input[@id='password'])[1]")
	private WebElement field2;
	@FindBy(xpath = "(//select[@id='user_type'])[1]")
	private WebElement field3;
	@FindBy(xpath = "(//button[@name='Create'])[1]")
	private WebElement savebutt;

	@FindBy(xpath = "(//div[@class='alert alert-danger alert-dismissible'])[1]")
	private WebElement alert;

	public AdminPage adminUser() {
		admnbutton.click();
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, newBut);
		newBut.click();
		return this;
	}

	public AdminPage newUserName() {
		field1.sendKeys("admin");
		return this;
	}

	public AdminPage newPassword() {
		field2.sendKeys("1234");
		return this;
	}

	public AdminPage clickRadioButton() {
		PageUtility pu = new PageUtility();
		pu.selectByIndex(field3, 2);
		return this;
	}

	public AdminPage clickSaveButton() {
		savebutt.click();
		return this;
	}

	public boolean isAlertDisplayed() {

		return alert.isDisplayed();

	}

}
