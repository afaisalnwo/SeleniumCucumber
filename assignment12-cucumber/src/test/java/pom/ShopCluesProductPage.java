package pom;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;






public class ShopCluesProductPage {

	private WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//div[@class='column col3']")
	WebElement FirstProduct;

	@CacheLookup
	@FindBy(xpath = "//button[text()='Add To Cart']")
	WebElement AddtoCart;

	@CacheLookup
	@FindBy(xpath = "//div[@id='snackbar']")
	WebElement MessageBar;


	public ShopCluesProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void ProductSelect()
	{
		FirstProduct.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Reporter.log("Clicked on the 1st product");
	}
	public void AddtoCart()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(MessageBar));
		wait.until(ExpectedConditions.invisibilityOf(MessageBar));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		AddtoCart.click();
		//Reporter.log("Clicked on the Add to Cart");

	}
	public void ValidateMessage()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(MessageBar));
		String Message = MessageBar.getText();
		System.out.println("Message is "+Message);
		//Reporter.log("Message is: "+Message);
		//assertTrue(Message.equals("Product added to cart"),"Message is not correct");
		assertEquals(Message, "Product added to cart");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}


