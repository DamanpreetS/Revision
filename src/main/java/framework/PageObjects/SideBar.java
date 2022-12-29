package framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.ReusableComponents;

public class SideBar extends ReusableComponents{
	WebDriver driver;
	
	public SideBar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="//button[text()=' Sign Out ']")
	WebElement SignOut;
	
	@FindBy(css=".fa-handshake-o")
	WebElement Orders;
	
	public VerifyOrders openOrder()
	{
		Orders.click();
		VerifyOrders verifyOrders=new VerifyOrders(driver);
		return verifyOrders;
	}
	
	public WebElement SignOut()
	{
		return SignOut;
	}
}
