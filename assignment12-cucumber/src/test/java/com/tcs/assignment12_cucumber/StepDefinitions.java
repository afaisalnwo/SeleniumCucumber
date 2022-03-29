package com.tcs.assignment12_cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Common;
import pom.Navigation;
import pom.ShopCluesProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;


public class StepDefinitions {

	Common common;

	WebDriver driver;
	String browser = "chrome";
	String baseUrl = "https://www.shopclues.com/";


	@Before
	public void setup() {
		common = new Common();
		common.setupBrowser(browser, baseUrl);
		this.driver = common.getDriver();
	}
	
	@After
	public void tearDown() {
		common.quitBrowser();
	}

	@Given("I am on the Shopclues homepage and Notification is closed")
	public void CloseNotification() {
		
		Navigation navigation = new Navigation(driver);
		navigation.CancelNotification();
		
	}
	@When("I click on ProductCategory {string} and Product {string}")
	public void NavigateToProduct(String ProductCategory, String Product) {
		Navigation navigation = new Navigation(driver);
		navigation.NavigateToMenu(ProductCategory, Product);
	}
	
	@Then("All Curtains are displayed on the a new page")
	public void ProductCatNewPage() {
		Navigation navigation = new Navigation(driver);
		navigation.WindowSwitch();
	}



	@Given("I am on the Curtain product page")
	public void OnProductPage() {
		
		System.out.println(driver.getTitle());
		
		
	}
	@When("I click on first product")
	public void SelectFirstProduct() {
		ShopCluesProductPage productpage = new ShopCluesProductPage(driver);
		productpage.ProductSelect();
	}
	
	@Then("Curtains product page will be displayed")
	public void ProductOnnewPage() {
		Navigation navigation = new Navigation(driver);
		navigation.WindowSwitch();
		
	}
	@Then("Upon clicking Product added to cart message will appear on clicking Add to cart")
	public void AddtoCartandValidate() {
		ShopCluesProductPage productpage = new ShopCluesProductPage(driver);
		productpage.AddtoCart();
		productpage.ValidateMessage();
	}
}
