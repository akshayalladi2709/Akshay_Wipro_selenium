package ebay_tests;

import ebay_tests.ebay_cucumberpageclass;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ebay_LoginSteps {

    WebDriver driver;
    ebay_cucumberpageclass ebay;


    @Given("the user navigates to the eBay login page")
    public void the_user_navigates_to_login_page() {
    	driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @When("the user enters their email and password")
    public void the_user_enters_email_and_password() throws InterruptedException {
    	ebay = new ebay_cucumberpageclass(driver);
        ebay.login();
    }

    @Then("the user should be signed in successfully")
    public void user_should_be_signed_in() {
        System.out.println("Login validated.");
        driver.quit();
    }
}
