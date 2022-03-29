package pom;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigation {

	private WebDriver driver;

	String parentWinHandle; 


	@CacheLookup
	@FindBy(xpath = "//button[@class='moe-chrome-style-notification-btn moe-btn-close moe-block-class']")
	WebElement DontAllow;
	@CacheLookup
	@FindBy(xpath="//a[text()='Home & Kitchen']")
	WebElement RibbonMenuItem;
	@CacheLookup
	@FindBy(xpath="//a[text()='Curtains']")
	WebElement MenuItem;

	public Navigation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void CancelNotification()
	{
		parentWinHandle = driver.getWindowHandle(); 
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(DontAllow));
		DontAllow.click();	
		//Reporter.log("Clicked on Don't Allow");
	}
	//@Parameters({"productCategory", "product"})
	public void NavigateToMenu(String productCat, String product)
	{
		String xpathProcductCategory = "//a[text()='"+ productCat+"']";
		String xpathProduct = "//a[text()='"+product+"']";


		WebDriverWait wait = new WebDriverWait(driver,30);
		RibbonMenuItem = driver.findElement(By.xpath(xpathProcductCategory));
		RibbonMenuItem.click();
		//Reporter.log("Clicked on Product Category: "+productCat);
		MenuItem = driver.findElement(By.xpath(xpathProduct));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(MenuItem));
		MenuItem.click();
		//Reporter.log("Clicked on Product: "+product);

	}

	public void WindowSwitch()
	{
		Set<String> winHandles = driver.getWindowHandles(); 
		//Loop through all handles 
		for(String handle: winHandles)
		{ 
			if(!handle.equals(parentWinHandle))
			{ 
				driver.switchTo().window(handle); 
				//System.out.println(handle);
				System.out.println("Title of the new window: " +  driver.getTitle()); 
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//Reporter.log("Switched to new Window"+driver.getTitle());
			}
		} 
	}

}
