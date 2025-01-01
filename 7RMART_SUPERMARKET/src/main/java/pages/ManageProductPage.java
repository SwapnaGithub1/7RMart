package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;


public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='btn btn-rounded btn-danger'])[1]")
	private WebElement newbut;
	@FindBy(xpath = "(//input[@id='title'])[1]")
	private WebElement Tfield;
	@FindBy(xpath = "//button[@class='btn btn-danger' and @type='submit']")
	private WebElement savebut;

	public ManageProductPage clickNewItem() {
		newbut.click();
		return this;
	}

	public ManageProductPage enterData(String product) {
		Tfield.sendKeys(product);
		return this;
	}

	public ManageProductPage clickSaveButton() {
		PageUtility pu = new PageUtility();
		pu.jsExecuterClick(savebut, driver);
		return this;

	}

	public String isAlertPresent() {
		return driver.switchTo().alert().getText();

	}
	

}
