package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterTextPage {
	WebDriver driver;

	public FooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="")private WebElement
	// @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//i[@class='fas
	// fa-arrow-circle-right']")private WebElement moreinfo;
	@FindBy(xpath = "(//textarea[@id='content'])[1]")
	private WebElement textfield1;
	@FindBy(xpath = "(//a[@role='button'])[1]")
	private WebElement updatebutton;
	@FindBy(xpath = "(//input[@id='email'])[1]")
	private WebElement textField2;
	@FindBy(xpath = "(//input[@id='phone'])[1]")
	private WebElement textfield3;
	@FindBy(xpath = "//button[normalize-space()='Update']")
	private WebElement updatebut;
	@FindBy(xpath = "//h5[normalize-space()='Alert!']")
	private WebElement alert;

	public FooterTextPage updateButton() {
		updatebutton.click();
		return this;
	}

	public FooterTextPage enterName(String name) {
		textfield1.clear();
		textfield1.sendKeys(name);
		return this;

	}

	public FooterTextPage enterMailAddress(String mail) {
		textField2.clear();
		textField2.sendKeys(mail);
		return this;
	}

	public FooterTextPage enterContactNo(String no) {
		textfield3.clear();
		textfield3.sendKeys(no);
		return this;
	}

	public FooterTextPage saveUpdateButton() {
		updatebut.click();
		return this;
	}

	public boolean updateAvailable() {
		return updatebutton.isDisplayed();
	}

	public boolean isAlertPresent() {
		return alert.isDisplayed();
	}

}
