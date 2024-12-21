package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement pswd;
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	private WebElement button;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement searchElement;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alert;

	public LoginPage enterUsername(String uname) {

		username.sendKeys(uname);
		return this;

	}

	public LoginPage enterPassword(String Pswd) {
		pswd.sendKeys(Pswd);
		return this;
	}

	public HomePage signin() {
		button.click();
		return new HomePage(driver);
	}

	public boolean isHomePageloaded() {
		return searchElement.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
