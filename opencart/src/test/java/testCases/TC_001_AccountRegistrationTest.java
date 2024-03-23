package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups= {"sanity","master"})
	public void verify_account_registration()
	{
		try
		{
		logger.info("****Account Registration Test Case Started.****");
		HomePage hp =new HomePage(driver);
		logger.info("Clicking My Account");
		hp.clickMyAccount();
		logger.info("Clicking Account Registration");
		hp.clickRegister();
			
		AccountRegistrationPage reg = new AccountRegistrationPage(driver);
		logger.info("Filling Registration Page");
		reg.setFirstName(randomeString());
		reg.setLastName(randomeString());
		reg.setEmail(randomeString()+"@gmail.com");
		reg.setTelephone(randomeNumeric());
		String password=randomeAlphaNumeric();
		reg.setPassword(password);
		reg.setConfirmPassword(password);
		reg.setPrivacyPolicy();
		logger.info("Clicking Continue Button");
		reg.submitButton();
		
		if(reg.getConfirmationMsg().equals("Your Account Has Been Created!"))
		{
		//	Assert.assertEquals(reg.getConfirmationMsg(), "Your Account Has Been Created!");
			logger.info("Account Created.");
		}
		else
		{
			logger.error("Account not Created");
			Assert.fail();
			
		}
		}
		catch(Exception e)
		{
			logger.error("Test Case Failed");
		}
		
		logger.info("****Account Registration Test Case Ended.****");
	}

	
	
	
	
}
