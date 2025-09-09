package Step_Definition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayLogin_Step {
	WebDriver driver;
	Ebay_PageClass pg1;
	
	@Given("Page is opened in a browser")
	public void page_is_opened_in_a_browser() {
		driver = new ChromeDriver();
        
        pg1 = new Ebay_PageClass(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.ebay.com/");
        System.out.println("Opened EBay website successfully");
	}

	@When("Enter valide emai and password")
	public void enter_valide_emai_and_password() throws InterruptedException {
        driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&sgfl=gh");

        pg1.email_in();
        pg1.con_in();
        pg1.pass_in();

        Thread.sleep(2000); // pauses for 2 seconds
	}
	
	@When("Click on sigin")
	public void click_on_sigin() {
        pg1.submit_in();
	}

	@Then("Logged in to the account")
	public void logged_in_to_the_account() {
		System.out.println("Sucessfully Loggedin");
	}
}
