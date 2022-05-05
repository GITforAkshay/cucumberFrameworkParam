package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	WebDriver driver;
	
	public Hooks(TestContextSetup testContextSetup) throws IOException
	{
		this.testContextSetup = testContextSetup;
		this.driver=testContextSetup.testBase.webDriverManager();
	}
	
	@After
	public void afterScenario() throws IOException
	{
		driver.quit();	
	}
	
	@AfterStep
	public void getScreenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			File fil =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filByte = FileUtils.readFileToByteArray(fil);
			scenario.attach(filByte, "image/png", scenario.getName().toString());
		}

	}
	
	

}
