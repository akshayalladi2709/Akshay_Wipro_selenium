package Step_Definition;

//Page Object calling in search

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search1_Step {
	WebDriver driver;
	@Given("login user and search button available")
	public void login_user_and_search_button_available() {
		 driver=new ChromeDriver();
			driver.get("http://zero.webappsecurity.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	}

	
	@When("^Enter (.*) and then use keyboard enter key$")
	public void enter_item_and_then_use_keyboard_enter_key(String item) {
		PageClass pg=new PageClass(driver);
		pg.search(item);
	   
	}

	@Then("List of output relevant to input")
	public void list_of_output_relevant_to_input() {
		driver.close();
	    
	}
}
