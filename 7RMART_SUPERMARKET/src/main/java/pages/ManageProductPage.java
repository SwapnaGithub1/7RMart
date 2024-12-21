package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

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

	public ManageProductPage newItem() {
		newbut.click();
		return this;
	}

	public ManageProductPage enterData(String prod) {
		Tfield.sendKeys(prod);
		return this;
	}

	public ManageProductPage save() {
		PageUtility pu = new PageUtility();
		pu.jsExecuterClick(savebut, driver);
		return this;

	}

	public String alertPresent() {
		return driver.switchTo().alert().getText();

	}
	/*
	 * public void alertok() throws InterruptedException { WaitUtility wu = new
	 * WaitUtility();
	 * 
	 * wu.wait(2); PageUtility pu = new PageUtility(); pu.simpleAlert(driver); }
	 */

}