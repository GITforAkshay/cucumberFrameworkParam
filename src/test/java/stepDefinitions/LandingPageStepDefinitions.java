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
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	//WebDriver driver;
	String landingPageItemName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is in the Greencart Landing Page")
	public void user_is_in_the_greencart_landing_page() {
		
		Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));
	}
	@When("^User searches with the item short name (.+) in Landing Page$")
	public void user_searches_with_the_item_short_name_in_landing_page(String item) throws InterruptedException {

		landingPage.searchItem(item);	
		Thread.sleep(3000);
	}
	@When("Extracts the actual product name from Landing Page")
	public void extracts_the_actual_product_name_from_landing_page() throws InterruptedException {
		//testContextSetup.genericUtils.implicitWait(10);
		//Thread.sleep(10000);
		testContextSetup.landingPageItemName = landingPage.getItem().split("-")[0].trim();
		//landingPage.getTopDealsPage();		//need to add
		//testContextSetup.genericUtils.switchToChild();
	}
	
	//And User moves to Offers Page
	@When("User moves to Offers Page")
	public void User_moves_to_Offers_Page() throws InterruptedException {
		landingPage.getTopDealsPage();	
		//Thread.sleep(10000);
		testContextSetup.genericUtils.switchToChild();
		
	}
	
	
	@When("Added {string} items of the selected product into the cart")
	public void added_items_of_the_selected_product_into_the_cart(String count) {
	    // Write code here that turns the phrase above into concrete actions
	    landingPage.selectNumberOfProducts(count);
	    landingPage.addItemToCart();
	}
	

	

}
