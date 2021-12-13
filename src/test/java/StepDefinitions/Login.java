package StepDefinitions;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchByEamil;
import Utilities.PropertyVC;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Login extends BaseClass {

	public WebDriver driver;
	@Before
	public void setup() throws IOException {
		PropertyVC obj=new PropertyVC("conf.properties");
		String br=obj.getKey("browser");
		logger=Logger.getLogger("login");
		Properties p=new Properties();
		p.load(new FileInputStream(new File("conf.properties")));
		PropertyConfigurator.configure(p);
		if(br.equalsIgnoreCase("chrome")){
		    System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		    driver=new ChromeDriver();
		    logger.info("******launching browser***********");
		    driver.manage().window().maximize();
		}
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		    driver=new FirefoxDriver();
			
		}
		
	}
	
	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() {
		
	    l=new LoginPage(driver);
		cu=new AddCustomerPage(driver);
		
	  
	  
	}

	@When("User Open URL as {string}")
	public void user_open_url_as(String url) {
		logger.info("******launching url***********");
	    driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailid, String password) {
		logger.info("******Enter email&password ***********");
	     l.enterEmailId(emailid);
	     l.enterPasswor(password);
	}

	@When("click on Login")
	public void click_on_login() {
		logger.info("****** click on loginButton***********");
	    l.loginButton();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String Expectedtitle) {
		if(driver.getTitle().equalsIgnoreCase(Expectedtitle)) {
			logger.info("******Both title matched***********");
			Assert.assertTrue(true);
			System.out.println("this is if part");
		}else {
			driver.close();
			System.out.println("this is failed else part");
			logger.info("******both title not matched***********");
			Assert.assertTrue(false);
			
		
		}
		
	}

	@When("click on logout link")
	public void click_on_logout_link() throws InterruptedException {
		Thread.sleep(4000);
		logger.info("******click on logout button***********");
		l.btnlogout.click();
	}

	@Then("close the browser")
	public void close_the_browser() {
		logger.info("******close the browser***********");
	    driver.close();
	}
	@Then("user can view Dashboad")
	public void user_can_view_dashboad() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("******both titles are matched***********");
		Assert.assertEquals("Dashboard / nopCommerce administration",cu.getTilte()); 
	
	}

	@When("user click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		cu.customerMenu.click();
	}

	@When("click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		cu.customerItem.click();
	   
	}

	@When("click on Add new Button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(3000);
		cu.addcustomer.click();
	    
	}

	@Then("user can see customer creation page")
	public void user_can_see_customer_creation_page() throws InterruptedException {
		Thread.sleep(3000);
	  Assert.assertEquals("Add a new customer / nopCommerce administration", cu.getTilte());
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("******Entering customerinfo***********");
		Thread.sleep(4000);
		String email=generateEmail()+"@gmail.com";
		cu.txtEmail.sendKeys(email);
	    cu.txtpassword.sendKeys("1234567");
	    cu.firstName.sendKeys("benarji");
	    cu.lastName.sendKeys("narada");
	    cu.gender("Male");
	    cu.datePicker.sendKeys("12/16/2021");
	    cu.companyname.sendKeys("Qede");
	    cu.newletterName("Your store name");
	    Thread.sleep(3000);
	    cu.customersRole("Guests");
	    Thread.sleep(2000);
	    cu.manageofVendor("Vendor 1");
	    cu.Admincomment.sendKeys("this is guest");
	    
	   
	}

	@When("click save button")
	public void click_save_button() {
		logger.info("******clickin on save button***********");
	   cu.saveButton.click();
	}

	@Then("user should see {string}")
	public void user_should_see(String string) throws InterruptedException {
		Thread.sleep(3000);
		logger.info("******wait for customer creation successfull massege***********");
     Assert.assertTrue(driver.getPageSource().contains(string));
	    
	}
//search by email id
	@When("Enter customer email")
	public void enter_customer_email() {
		logger.info("******customer search by email***********");
		search=new SearchByEamil(driver);
		search.setEamil("victoria_victoria@nopCommerce.com");
	    
	}
	@When("user click search button")
	public void user_click_search_button() throws InterruptedException {
		search.clickAddButton();
		Thread.sleep(3000);
	}
	@Then("user should found email in search table")
	public void user_should_found_email_in_search_table() {
		logger.info("******verifying cusomer details in table***********");
		boolean status = search.verifyByEamil("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true,status);
	}

//search by firstname and lastname

@When("Enter customer firstname and lastname")
public void enter_customer_firstname_and_lastname() {	
	logger.info("******search by first and last name***********");
	search=new SearchByEamil(driver);
	search.enterFirstName("Victoria","Terces");
  
}
@Then("user should found lastname and firstname in search table")
public void user_should_found_lastname_and_firstname_in_search_table() {
	logger.info("******verifying cusomer details in table***********");
	boolean status = search.verifyByFirst_LastName("Victoria","Terces");
	Assert.assertEquals(true,status);
   
}




}
