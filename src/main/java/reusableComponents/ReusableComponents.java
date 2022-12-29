package reusableComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {
	WebDriver driver;
	
	public ReusableComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitforElementtoAppear(WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitforElementtoDisAppear(WebElement element)
	{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
