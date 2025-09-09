package Step_Definition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayShopByCat {
	WebDriver driver;
	Ebay_PageClass pg3;
	
	@Given("Website browser open")
	public void website_browser_open() {
		driver = new ChromeDriver();
        
        pg3 = new Ebay_PageClass(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.ebay.com/");
        System.out.println("Opened EBay website successfully");
	}

	@When("Click on ShopByCateg and select the categ")
	public void click_on_shop_by_categ_and_select_the_categ() throws InterruptedException {
		pg3.ShopByCatgy_in();
		Thread.sleep(2000); // pauses for 2 seconds
	}

	@Then("Display the results of it")
	public void display_the_results_of_it() {

	}
}
