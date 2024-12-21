package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath="")private WebElement
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][normalize-space()='More info'])[1]")
	private WebElement subcatmoreinfo;
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[8]")
	private WebElement manaeprodmoreinfo;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement adminbut;
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[9]")
	private WebElement managenewsmoreinfo;
	@FindBy(xpath = "(//a[@class='dropdown-item'][normalize-space()='Logout'])[1]")
	private WebElement logoutbut;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	private WebElement check;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	private WebElement more;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//i[@class='fas fa-arrow-circle-right']")
	private WebElement footermoreinfo;

	public SubCategoryPage subCatmorenfo() {
		subcatmoreinfo.click();
		return new SubCategoryPage(driver);
	}

	public ManageProductPage manageproduct() {
		manaeprodmoreinfo.click();
		return new ManageProductPage(driver);
	}

	public ManageNewsPage moreInfo() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

	public FooterTextPage footerText() {
		footermoreinfo.click();
		return new FooterTextPage(driver);
	}

	public ManageContactPage managecont() {
		// PageUtility pageutility = new PageUtility();
		// pageutility.jsExecuterClick(more, driver);
		more.click();
		return new ManageContactPage(driver);
	}

	public LoginPage logout() {

		logoutbut.click();
		return new LoginPage(driver);

	}

	public HomePage homepage() {
		adminbut.click();
		return this;
	}

}
