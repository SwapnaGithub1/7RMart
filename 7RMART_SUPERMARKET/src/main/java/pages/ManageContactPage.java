package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

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
		PageUtility pu = new PageUtility();
		pu.jsExecuterClick(newbut, driver);
		// newbut.click();
		return this;
	}

	public ManageContactPage enterMobno(String Mno) {
		TField1.clear();
		TField1.sendKeys(Mno);
		return this;
	}

	public ManageContactPage enterMail(String mail) {

		TField2.clear();
		TField2.sendKeys(mail);
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

	public ManageContactPage update() {
		PageUtility pu = new PageUtility();
		pu.jsExecuterClick(updatbutton, driver);
		return this;
	}

	public boolean alertdiplayed() {
		return alert.isDisplayed();
	}

}
