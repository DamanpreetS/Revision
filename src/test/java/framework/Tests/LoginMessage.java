package framework.Tests;

import org.testng.annotations.Test;


import framework.TestComponets.BaseTest;

public class LoginMessage extends BaseTest{

	
	@Test
	public void YerrorMessage()
	{
		loginPage.Login("preethanjhra67@gmail.com", "Waheguru1@73873");
		org.testng.Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password.");
	}
	@Test
	public void YerrorMessage1()
	{
		loginPage.Login("preethanjhra68@gmail.com", "Waheguru1@73873");
		org.testng.Assert.assertEquals(loginPage.getErrorMessage(), "3 email or password.");
	}
	@Test
	public void YerrorMessage2()
	{
		loginPage.Login("preethanjhra97@gmail.com", "Waheguru1@73873");
		org.testng.Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password.");
	}
}
