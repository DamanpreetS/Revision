package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import reusableComponents.ReusableComponents;

public class MyCart extends ReusableComponents {

	WebDriver driver;
	
	public MyCart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By  itemsCart=By.cssSelector("div[class='cart'] ul");
	By itemName=By.cssSelector("ul h3");
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	public Boolean checkElements(String productName)
	{
		List<WebElement> items=driver.findElements(itemsCart);
		Boolean listitem= items.stream().anyMatch(item ->item.findElement(itemName)
				.getText().contains(productName));
		return listitem;
	}
	public Payments checkout()
	{
		 checkOut.click();
		 return new Payments(driver);
	}
	
}
