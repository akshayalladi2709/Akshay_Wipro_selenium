package Step_Definition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbaySearching {
	WebDriver driver;
	Ebay_PageClass pg2;
	
	@Given("Page should be opened in browser")
	public void page_should_be_opened_in_browser() {
		driver = new ChromeDriver();
        
        pg2 = new Ebay_PageClass(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.ebay.com/");
        System.out.println("Opened EBay website successfully");
	}

	@When("^Enter (.*) and then enter$")
	public void enter_watch_and_then_enter(String product) throws InterruptedException {
    	pg2.searchMultipleItems(product);
    	Thread.sleep(2000); // pauses for 2 seconds
	}
	
	@Then("items should be displayed")
	public void items_should_be_displayed() {

	}

}
