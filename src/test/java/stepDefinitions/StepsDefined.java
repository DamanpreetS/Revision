package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import framework.PageObjects.LoginPage;
import framework.PageObjects.MyCart;
import framework.PageObjects.OrderConfirmation;
import framework.PageObjects.Payments;
import framework.PageObjects.ProductCatalogue;
import framework.TestComponets.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefined extends BaseTest{
	public LoginPage loginPage;
	public ProductCatalogue pCat;
	public MyCart myCart;
	String productName="ZARA";

	@Given("I landed on Ecommerce Page")
	public void i_landed_on_ecommerce_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		loginPage=launchApplication();
	}
	@Given("Logged in with username (.+) and password (.+)")
	public void logged_in_with_username_rahulshetty_gmail_com_and_password_iamking(String UserName, String Pasword) {
	    // Write code here that turns the phrase above into concrete actions
		pCat=loginPage.Login(UserName,Pasword);
	}
	@When("I add product ZARA COAT {int} to Cart")
	public void i_add_product_zara_coat_to_cart(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		 	myCart=pCat.AddToCart(productName);	
			Boolean listitem=myCart.checkElements(productName);
			Assert.assertTrue(listitem);
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_confirmation_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
		Payments payments=myCart.checkout();
		payments.selectCountryName("India");
		OrderConfirmation orderC=payments.placeOrder();
	}
	
}
