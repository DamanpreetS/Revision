package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.ReusableComponents;

public class VerifyOrders extends ReusableComponents{

	WebDriver driver;
	
	public VerifyOrders(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tbody tr th")
	List<WebElement> orderList;
	
	public boolean checkOrderID(String OrderID)
	{
		return orderList.stream().anyMatch(order-> order.getText().equalsIgnoreCase(OrderID));
	}
}
