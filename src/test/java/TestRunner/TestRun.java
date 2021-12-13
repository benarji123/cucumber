package TestRunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( 
		features=".//Features/Login.feature",
		glue="StepDefinitions",
		dryRun=false,
	    monochrome=true,
		plugin= {"pretty","html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json"}
		//tags= "@regression and @sanity"
		
		
		)
public class TestRun {
	

}
