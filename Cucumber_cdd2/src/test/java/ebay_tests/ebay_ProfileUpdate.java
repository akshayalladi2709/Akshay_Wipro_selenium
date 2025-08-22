package ebay_tests;

import ebay_tests.ebay_cucumberpageclass;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ebay_ProfileUpdate {

    WebDriver driver;
    ebay_cucumberpageclass ebay;

    @Given("the user is logged in to update address")
    public void user_logged_in_to_update_address() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.ebay.com/");
        ebay = new ebay_cucumberpageclass(driver);
        ebay.login();
    }

    @When("the user updates address and name in account settings")
    public void user_updates_address_and_name() throws InterruptedException {
        ebay.changeAddressAndName();
    }

    @Then("the updated profile information should be saved")
    public void updated_info_should_be_saved() {
        System.out.println("Profile information updated.");
        driver.quit();
    }
}
