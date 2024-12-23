package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[9]") private
	// WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement textfield;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageNewsPage newButon() {
		newButton.click();
		return this;
	}

	public ManageNewsPage textField(String news) {
		textfield.sendKeys(news);
		return this;
	}

	public ManageNewsPage save() {
		savebutton.click();
		return this;
	}

	public boolean isalertdisplayed() {
		return alert.isDisplayed();
	}

}
