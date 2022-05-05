package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features" 
					,glue = "stepDefinitions" 
					,monochrome=true
					//,tags="@Checkout"
					,tags="@Checkout or @OffersPage"
					//,tags="@OffersPage"
					//,plugin={"pretty","html:target/cucumber.html"}
					,plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cucumber.xml"
							,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
					)

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	@Override	
	@DataProvider(parallel=true)
	    public Object[][] scenarios()
	    {
		 return super.scenarios();
	    }

}
