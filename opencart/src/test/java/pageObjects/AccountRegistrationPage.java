package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement eMail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement passwordConfirm;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreechkbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement submitbtn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement confirmationMsg;

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		eMail.sendKeys(email);

	}
	
	public void setTelephone(String phone)
	{
		telephone.sendKeys(phone);
	}
	
	public void setPassword(String passwd)
	{
		password.sendKeys(passwd);
	}
	
	public void setConfirmPassword(String confpasswd)
	{
		passwordConfirm.sendKeys(confpasswd);
	}
	
	public void setPrivacyPolicy()
	{
		agreechkbox.click();
	}
	
	public void submitButton()
	{
		submitbtn.click();
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			return(confirmationMsg.getText());
		}
		catch(Exception e)
		{
			 return(e.getMessage());
		}
		
	}

}