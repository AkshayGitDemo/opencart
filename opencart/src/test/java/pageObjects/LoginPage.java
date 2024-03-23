package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
	private WebElement login;
	
	@FindBy(xpath="//input[@id='input-email']") 
	private WebElement eMailAddress;
	
	@FindBy(xpath="//input[@id='input-password']") 
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']") 
	private WebElement loginbutton;
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void setUsername(String username)
	{
		eMailAddress.sendKeys(username);
	}
	
	public void setPassword(String passd)
	{
		password.sendKeys(passd);
	}
	
	public void clickLoginButton()
	{
		loginbutton.click();
	}
	
	

}
