package framework.PageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import reusableComponents.ReusableComponents;

public class Payments extends ReusableComponents{

	WebDriver driver;
	
	public Payments(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(xpath="//section[contains(@class,'list-group')]/button //span")
	List<WebElement> countries;
	
	@FindBy(css=".details__user a[class*='submit']")
	WebElement placeOrder;
	
	public void selectCountryName(String CountryName)
	{
		waitforElementtoAppear(selectCountry);
		selectCountry.sendKeys("ind");
		WebElement countryName= countries.stream().filter(countryc -> countryc.getText().equalsIgnoreCase(CountryName)).findFirst().orElse(null);		
		countryName.click();
	}
	
	public OrderConfirmation placeOrder()
	{
	 placeOrder.click();
	 return new OrderConfirmation(driver);
	}
}
