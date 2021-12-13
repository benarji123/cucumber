package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	@CacheLookup
	@FindBy(name="Email")
	public WebElement  enterEamilId;
	
	@CacheLookup
	@FindBy(name="Password")
	public WebElement enterPassword;
	
	@CacheLookup
	@FindBy(xpath="//button[@type='submit']")
	public WebElement LoginButton;
	
	@CacheLookup
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	public WebElement btnlogout;
	
  public void enterEmailId(String email  ) {
	  enterEamilId.clear();
	  enterEamilId.sendKeys(email);
  }
  public void enterPasswor(String password) {
	  enterPassword.clear();
	  enterPassword.sendKeys(password);
  }
  public void loginButton() {
	  LoginButton.click();
  }
}
