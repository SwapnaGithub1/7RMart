package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

public class SubCategoryPage {
	WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][normalize-space()='More info'])[1]")
	private WebElement subcatmoreinfo;
	@FindBy(xpath = "(//a[@class='btn btn-rounded btn-danger'])[1]")
	private WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement dropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement textsub;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement uploadbutton;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[5]/a[2]/i[1]")
	private WebElement delbut;

	public void subCatmorenfo1() {
		subcatmoreinfo.click();

	}

	public SubCategoryPage newButton() {
		newbutton.click();
		return this;
	}

	public SubCategoryPage selectCategory() {

		PageUtility pageuti = new PageUtility();
		pageuti.selectByIndex(dropdown, 1);
		return this;
	}

	public SubCategoryPage SubcatInput(String Catname) {
		textsub.sendKeys(Catname);
		return this;
	}

	public SubCategoryPage imageupload() throws AWTException {
		FileUploadUtilities fileutility = new FileUploadUtilities();
		fileutility.fileuploadRobotClass(uploadbutton, Constants.ImageBall);
		return this;
	}

	public SubCategoryPage imageupload1() {
		uploadbutton.sendKeys(Constants.ImageBall);
		return this;
	}

	public SubCategoryPage save() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

	public SubCategoryPage deleteCat() {
		delbut.click();
		return this;
	}

	public void alertAccept() {
		PageUtility pu = new PageUtility();
		pu.simpleAlert(driver);
	}
}
