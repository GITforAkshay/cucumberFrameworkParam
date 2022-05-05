package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	
	WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void switchToChild()
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
	}
	
	public void explicitWait(int sec, By by)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(sec));
		w.until(ExpectedConditions.presenceOfElementLocated(by));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000*milisec));
	}
	

}
