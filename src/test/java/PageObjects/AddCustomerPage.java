package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@CacheLookup
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
	public WebElement customerMenu;
	@CacheLookup
	@FindBy(xpath="(//p[contains(text(),' Customers')])[1]")
	public WebElement customerItem;
    @CacheLookup
    @FindBy(xpath="//a[@class='btn btn-primary']")
    public WebElement addcustomer;
    @CacheLookup
    @FindBy(name="Email")
    public WebElement txtEmail;
    @CacheLookup
    @FindBy(id="Password")
    public WebElement txtpassword;
    @CacheLookup
    @FindBy(name="FirstName")
    public WebElement firstName;
    
    @CacheLookup
    @FindBy(name="LastName")
  public WebElement lastName;
    
    @CacheLookup
    @FindBy(id="Gender_Male")
    public WebElement rdMale;
    
    @CacheLookup
    @FindBy(id="Gender_Female")
    public WebElement rdFemale;             //li[text()='Your store name']
    
    @CacheLookup
    @FindBy(id="DateOfBirth")
    public WebElement datePicker;
    
    @CacheLookup
    @FindBy(id="Company")
    public WebElement companyname;
    
    @CacheLookup
    @FindBy(xpath="//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]")
    public WebElement TestSote2;
  
    @CacheLookup
    @FindBy(xpath="//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[1]")
    public WebElement YourSotrename;
     @CacheLookup
     @FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div")
     public WebElement Newsletter;
     
     @CacheLookup
     @FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")
     WebElement customerole;
     
     @CacheLookup
     @FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]")
     public WebElement Administrator;
     
     @CacheLookup
     @FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]")
     public WebElement ForumModerators;
     
     @CacheLookup
     @FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")
     public WebElement Guests;
     @CacheLookup
     @FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]")
     public  WebElement Register;
      @CacheLookup
      @FindBy(name="VendorId")
      public  WebElement vendore;
      @CacheLookup
      @FindBy(name="AdminComment")
      public WebElement Admincomment;
      
      @CacheLookup
      @FindBy(xpath="(//i[@class='far fa-save'])[1]")
      public WebElement saveButton;
      //methods
      public void gender(String Gen) {
    	  if(Gen.equals("Male")) {
    		  rdMale.click();
    	  }else if(Gen.equals("Female")) {
    		  rdFemale.click();
    	  }
    		  
      }
      public void newletterName(String storename) {
    	  Newsletter.click();
    	  if(storename.equalsIgnoreCase("your store name")) {
    		  YourSotrename.click();
    	  } else if(storename.equalsIgnoreCase("Test Store2")) {
    		  TestSote2.click();
    	  }
    		  
    	  
      }
      public void customersRole(String role) throws InterruptedException {
    	  ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
    	  customerole.click();
    	 
    	//  customerole.clear();
    	  Thread.sleep(2000);
    	 // customerole.click();
    	  if(role.equalsIgnoreCase("Administrator")) {
    		  Administrator.click();
    	  }else if(role.equalsIgnoreCase("ForumModerators")) {
    		  ForumModerators.click();
    		  
    	  }else if(role.equalsIgnoreCase("Guests")) {
    		  Guests.click();
    		  
    	  }else if(role.equalsIgnoreCase("Register")) {
    		  Register.click();
    	  }else if(role.equalsIgnoreCase("vendore")) {
    		  vendore.click();
    	  }
    	  
      }
      public void manageofVendor( String visibletext) {
    	  Select s=new Select(vendore);
    	  s.selectByVisibleText(visibletext);
    	  
      }
      public String getTilte() {
    	  String title=ldriver.getTitle();
    	  return title;
      }
    
}
