package StepDefinitions;



import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchByEamil;

public class BaseClass {
	 
	public SearchByEamil search;
	public AddCustomerPage cu;
	public LoginPage l;

	public Logger logger;
	public String generateEmail() {
		String email=RandomStringUtils.randomAlphabetic(5);
		return email;
	}
}
