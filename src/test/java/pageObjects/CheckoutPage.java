package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By cart = By.cssSelector("[alt='Cart']");
	By checkout = By.xpath("//*[text()='PROCEED TO CHECKOUT']");
	By promoCode = By.cssSelector(".promoCode");
	By applyBtn = By.cssSelector(".promoBtn");
	By promoApplyStatus = By.cssSelector(".promoInfo");
	By placeOrderBtn = By.xpath("//button[text()='Place Order']");
	By countryDropdown = By.cssSelector(".wrapperTwo div select"); 
	By checkbox = By.cssSelector(".chkAgree");
	By ProceedBtn = By.cssSelector(".wrapperTwo button");
	
	public void clickCart()
	{
		driver.findElement(cart).click();
	}
	
	public void getCheckoutPage()
	{
		driver.findElement(checkout).click();;
	}
	public void enterPromoCode()
	{
		driver.findElement(promoCode).sendKeys("rahulshettyacademy");
	}
	public void applyPromoCode() throws InterruptedException
	{
		driver.findElement(applyBtn).click();
		Thread.sleep(5000);   //remove it ---add WebDriverWait on element visible with css ".promoInfo"
	}
	
	public By getPromoApplyStatus()
	{
		return promoApplyStatus;
	}
	
	public String getPromoApplyStatusText() 
	{
		return driver.findElement(promoApplyStatus).getText();
	}
	
    public void placeOrder()
    {
    	driver.findElement(placeOrderBtn).click();
    }
    
    public void selectCountryDropdown(String country)
    {
    	Select s = new Select(driver.findElement(countryDropdown));
    	s.selectByVisibleText(country);
    }
    
    public void selectCheckbox()
    {
    	if (!driver.findElement(checkbox).isSelected())
    	{
    		driver.findElement(checkbox).click();
    	}
    	
    }
    
    public void clickProceedBtn()
    {
    	driver.findElement(ProceedBtn).click();
    }
	
	

}
