package framework.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import framework.PageObjects.MyCart;
import framework.PageObjects.OrderConfirmation;
import framework.PageObjects.Payments;
import framework.PageObjects.ProductCatalogue;
import framework.PageObjects.SideBar;
import framework.PageObjects.VerifyOrders;
import framework.TestComponets.BaseTest;
import framework.TestComponets.Retry;

public class StandaloneTest extends BaseTest {
	String OrderId;
	String productName="ZARA";
	
	@Test(dataProvider = "getData",groups = "Purchase")
	public void testapplication(HashMap<String, String> map)  throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		ProductCatalogue pCat=loginPage.Login(map.get("userName"),map.get("password"));
		
		
		MyCart myCart=pCat.AddToCart(productName);	
		Boolean listitem=myCart.checkElements(productName);
		Assert.assertTrue(listitem);
		Payments payments=myCart.checkout();
	
		payments.selectCountryName("India");
		OrderConfirmation orderC=payments.placeOrder();
		OrderId= orderC.orderConfirmation();
		
	}

	@Test(dependsOnMethods = "testapplication" , retryAnalyzer =  Retry.class)
	public void OrderHistory()
	{
		loginPage.Login("preethanjhra66@gmail.com","Waheguru@73873");
		VerifyOrders verifyOrders= new SideBar(driver).openOrder();
		Assert.assertTrue(verifyOrders.checkOrderID(OrderId));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("userName","preethanjhra66@gmail.com");
//		map.put("password", "Waheguru@73873");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("userName","preethanjhra69@gmail.com");
//		map1.put("password", "Waheguru@73873");
		List<HashMap<String,String>> list=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//framework//DataSets//PurchaseOrders.json");
		return new Object[][] {{list.get(0)},{list.get(1)}};
		

		//List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//framework//DataSets//PurchaseOrders.json");
		//return new Object[][]  {{data.get(0)}, {data.get(1) } };
	}
}
