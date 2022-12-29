package framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.ReusableComponents;

public class OrderConfirmation extends ReusableComponents  {

	WebDriver driver;
	String OrderId;
	public OrderConfirmation(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="label[class='ng-star-inserted']")
	WebElement orderID;
	
	public String orderConfirmation()
	{
		waitforElementtoAppear(orderID);
		String text=driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText();
		OrderId=text.split(" ")[1].trim();
		return OrderId;
	}
}
