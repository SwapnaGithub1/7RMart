package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
		
	}
public void selectByVisibleText(WebElement element,String visibleText)
{
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);;
		
	}
public void rightClick(WebElement dragableItem, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.contextClick(dragableItem);
}
public void doubleClick(WebElement dragableItem, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.doubleClick(dragableItem);
	
}
public void moveToElement(WebElement dropList, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.moveToElement( dropList);
	
}
public void dragAndDrop(WebElement  dragableItem, WebElement  dropList, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.dragAndDrop(dragableItem, dropList);
	
}
public void jsExecuterClick(WebElement item, WebDriver driver)
{
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("arguments[0].click();",item);
	
}
public void jsExecuterSendKeys(WebElement FieldItem, String value1, WebDriver driver)
{
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("arguments[0].value=value1;", FieldItem);
}
public void jsScroll(WebDriver driver)
{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,150)","");
	
}
public void simpleAlert(WebDriver driver)
{
	 
	 driver.switchTo().alert().accept();
	 driver.switchTo().alert().getText();
}

}
