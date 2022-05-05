package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By search = By.cssSelector("#search-field");
	By item = By.cssSelector("tr td:nth-child(1)");

	public void searchItem(String item)
	{
		driver.findElement(search).sendKeys(item);
	}
	
	public String getItem()
	{
		return driver.findElement(item).getText();
	}

}
