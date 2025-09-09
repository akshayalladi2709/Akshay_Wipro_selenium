package Step_Definition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayCart_Step {
	WebDriver driver;
	Ebay_PageClass pg2;
	
	@Given("Page is opened")
	public void page_is_opened() {
		driver = new ChromeDriver();
        
        pg2 = new Ebay_PageClass(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.ebay.com/");
        System.out.println("Opened EBay website successfully");
	}

	@When("Search for a product and add it cart")
	public void search_for_a_product_and_add_it_cart() throws InterruptedException {
		pg2.addCart_in();
        Thread.sleep(2000); // pauses for 2 seconds
	}

	@When("delete it from the cart")
	public void delete_it_from_the_cart() throws InterruptedException {
    	pg2.deleteCart_in();
    	Thread.sleep(2000); // pauses for 2 seconds
	}

	@Then("Search, adding and deleted is completed")
	public void search_adding_and_deleted_is_completed() {
		System.out.println("Sdarching, adding to cart and deleting is done for the product");
	}
}
