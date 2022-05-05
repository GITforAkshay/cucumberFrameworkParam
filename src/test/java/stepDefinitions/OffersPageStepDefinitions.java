package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {
	//WebDriver driver;
	String offersPageItemName;
	TestContextSetup testContextSetup;
	OffersPage offersPage;
	
	public OffersPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Then("^User searches with the same item short name (.+) in Offers Page$")
	public void user_searches_with_the_same_item_short_name_in_offers_page(String item) {
		testContextSetup.pageObjectManager.getOffersPage().searchItem(item);
	}
	@Then("Check whether same items are being displayed in the Offers Page")
	public void check_whether_same_items_are_being_displayed_in_the_offers_page() throws InterruptedException {
		//testContextSetup.genericUtils.implicitWait(8);
	    offersPageItemName = testContextSetup.pageObjectManager.getOffersPage().getItem();
	    System.out.println("--offersPageItemName : " + offersPageItemName);
	    System.out.println("--landingPageItemName : " + testContextSetup.landingPageItemName);
	    
	    Assert.assertEquals(offersPageItemName, testContextSetup.landingPageItemName);
	   
	}

}
