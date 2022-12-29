package framework.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.ReusableComponents;

public class LoginPage extends ReusableComponents{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="input[type='email']")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement erroeMsg;
	
	public ProductCatalogue Login(String userName, String Password)
	{
		
		this.userName.sendKeys(userName);
		this.password.sendKeys(Password);
		this.loginButton.click();
		return new ProductCatalogue(driver);
		
	}
	

	public String getErrorMessage() {
		// TODO Auto-generated method stub
		waitforElementtoAppear(erroeMsg);
		return erroeMsg.getText();
	}
}
