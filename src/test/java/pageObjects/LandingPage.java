package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By search = By.xpath("//*[@type='search']");
	By item = By.cssSelector(".product .product-name");
	By topDealsPage = By.linkText("Top Deals");
	By increase = By.cssSelector(".stepper-input .increment");
	By addToCart = By.cssSelector(".product-action button");
	
	//testContextSetup.driver.findElement(By.xpath("//*[@type='search']")).sendKeys(item);
	//testContextSetup.driver.findElement(By.cssSelector(".product .product-name")).getText();
	//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	
	public void searchItem(String item)
	{
		driver.findElement(search).sendKeys(item);
	}
	
	public String getItem()
	{
		return driver.findElement(item).getText();
	}
	
	public void getTopDealsPage()
	{
		driver.findElement(topDealsPage).click();
	}
	
	public String getLandingPageTitle()
	{
		return driver.getTitle();
	}
	
	public void selectNumberOfProducts(String count)
	{
		for(int i = Integer.parseInt(count)-1; i>0; i--)
		{
			//System.out.println(Integer.parseInt(count));
			//System.out.println("-------------under selectNumberOfProducts" + i);
			driver.findElement(increase).click();
		}
	}
	
	public void addItemToCart()
	{
		driver.findElement(addToCart).click();
	}

}
