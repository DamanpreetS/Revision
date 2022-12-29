package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.ReusableComponents;

public class ProductCatalogue extends ReusableComponents{
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products; 
	
	@FindBy(id="toast-container")
	WebElement container;
	
	@FindBy(css=".ng-animating")
	WebElement animator;
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cart;	
			
	By addToCart=By.cssSelector(".card .card-body .w-10");
	
	
	By productName=By.cssSelector("b");
	
	@FindBy(css=".mb-3")
	WebElement product; 
	
	
	public List<WebElement> getProducts()
	{
		waitforElementtoAppear(product);
		return products;
	}
	public WebElement getProductName(String ProductName)
	{
		WebElement el=getProducts().stream().filter(product->
		product.findElement(productName).getText().contains(ProductName)).findFirst().orElse(null);
		return el;
		}
	
	public MyCart AddToCart(String productName2) {
		// TODO Auto-generated method stub
		getProductName(productName2).findElement(addToCart).click();
		waitforElementtoAppear(container);
		waitforElementtoDisAppear(animator);
		cart.click();
		return new MyCart(driver);
	}
	
	
	
}
