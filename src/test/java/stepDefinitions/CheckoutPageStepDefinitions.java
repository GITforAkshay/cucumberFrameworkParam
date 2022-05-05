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
import pageObjects.CheckoutPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {
	//WebDriver driver;
	String offersPageItemName;
	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

    @Then("^User proceeds to checkout and validate the (.+) items in Checkout Page$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException{
    	checkoutPage.clickCart();
    	//Thread.sleep(3000);
    	checkoutPage.getCheckoutPage();
        
    }

    @Then("^Verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
    	
    	checkoutPage.enterPromoCode();
    	checkoutPage.applyPromoCode();
    	testContextSetup.genericUtils.explicitWait(10, checkoutPage.getPromoApplyStatus());
    	System.out.println("-----------------"+checkoutPage.getPromoApplyStatusText());
    	Assert.assertEquals(checkoutPage.getPromoApplyStatusText(),"Code applied ..!");
    	checkoutPage.placeOrder();
    	checkoutPage.selectCountryDropdown("India");
    	checkoutPage.selectCheckbox();
    	checkoutPage.clickProceedBtn();
        
    }

	
}
