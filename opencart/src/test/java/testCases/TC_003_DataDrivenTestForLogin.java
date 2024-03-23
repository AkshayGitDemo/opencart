package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC_003_DataDrivenTestForLogin extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void loginValidationDataDriven(String username, String password, String typeoftest ) {
		logger.info("***Starting Login Validation Test***");
		HomePage hp = new HomePage(driver);
		logger.info("Clicked My Account");
		hp.clickMyAccount();
		logger.info("Clicked Login");
		LoginPage lp = new LoginPage(driver);
		lp.clickOnLogin();
		logger.info("Entered Username and Password");
		lp.setUsername(username);
		lp.setPassword(password);
		logger.info("Clicked LoginIN button");
		lp.clickLoginButton();
		AccountPage ap = new AccountPage(driver);
		
		if(typeoftest.equalsIgnoreCase("Valid")&&ap.myAccountMsg() == true)
		{
			ap.clickLogout();
			logger.info("Account Successfully Logged in with valid Test Data");
			Assert.assertEquals(true, true);
		}
		else if(typeoftest.equalsIgnoreCase("InValid")&&ap.myAccountMsg() == true)
		{
			
			logger.info("Account Successfully Logged in with invalid Test Data");
			Assert.fail();
		}

		else if(typeoftest.equalsIgnoreCase("InValid")&&ap.myAccountMsg() == false)
		{
			
			logger.info("Unable to Log in with invalid Test Data");
			Assert.assertEquals(true, true);
		}
		
	}


}
