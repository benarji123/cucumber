package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchByEamil {
	WebDriver ldriver;
	WaitHelper wait;
	public SearchByEamil(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		 wait=new WaitHelper(ldriver);
	}
   @CacheLookup
   @FindBy(id="SearchEmail")
   WebElement txtEmail;
   @CacheLookup
   @FindBy(id="SearchFirstName")
   WebElement firsrname;
   @CacheLookup
   @FindBy(id="SearchLastName")
   WebElement Lastname;
   @CacheLookup
   @FindBy(id="search-customers")
   WebElement addbutton;
   @CacheLookup
   @FindBy(xpath="//table[@id='customers-grid']")
   WebElement table;
   public void setEamil(String email) {
	   wait.waitForElement(txtEmail, 2);
	   txtEmail.clear();
	   txtEmail.sendKeys(email);
	   
   }
   public void clickAddButton() {
	   wait.waitForElement(addbutton, 2);
	   addbutton.click();
   }
   public boolean verifyByEamil(String email) {
	   boolean flag=false;
	   List<WebElement> r = table.findElements(By.tagName("tr"));
	   for(int i=1;i<=r.size();i++) {
		  String tableEmail= ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
		  if(email.equals(tableEmail)) {
			  flag=true;
			  System.out.println(tableEmail);
			  break;
	   }
	 
   }
	   return flag;
}
   public void enterFirstName(String firstname,String lastname) {
	   wait.waitForElement(firsrname, 2);
	   firsrname.sendKeys(firstname);
	   wait.waitForElement(Lastname, 2);
	   Lastname.sendKeys(lastname);
   }
   public boolean verifyByFirst_LastName(String firstname,String lastname) {
	   boolean flag=false;
	   List<WebElement> r = table.findElements(By.tagName("tr"));
	   for(int i=1;i<=r.size();i++) {
		  String tablenames= ldriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
		 String[]obj= tablenames.split(" ");
		  if(obj[0].equals(firstname) && obj[1].equals(lastname)) {
			  flag=true;
			  System.out.println(tablenames);
			  break;
	   }
	 
   }
	   return flag;
}
}
   
