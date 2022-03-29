package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {
	private WebDriver driver;
	
	public void setupBrowser(String browser, String url) {
		String currDir = System.getProperty("user.dir");
		if (browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", currDir+ "/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", currDir+ "/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", currDir+ "/drivers/msedgedriver");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser");
			System.exit(0);	
		}
		
		
		driver.manage().window().maximize();
		
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");		
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeTab() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}














