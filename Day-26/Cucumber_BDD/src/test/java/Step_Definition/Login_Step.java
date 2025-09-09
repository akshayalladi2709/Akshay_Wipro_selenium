//package Step_Definition;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByClassName;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Login_Step {
//	WebDriver driver;
//	
//	@Given("login page should be open in default browser")
//	public void login_page_should_be_open_in_default_browser() {
//		driver = new ChromeDriver();
//        driver.get("http://zero.webappsecurity.com/login.html");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//
//	@When("click on username button and enter valid username")
//	public void click_on_username_button_and_enter_valid_username() {
//		driver.findElement(By.id("user_login")).click();
//        driver.findElement(By.id("user_login")).sendKeys("username");
//	}
//
//	@And("add password")
//	public void add_password() {
//		driver.findElement(By.id("user_password")).click();
//        driver.findElement(By.id("user_password")).sendKeys("password");
//	}
//
//	@When("click on signin button")
//	public void click_on_signin_button() {
//		driver.findElement(By.name("submit")).click();
//	}
//
//	@Then("login successfully and open home page")
//	public void login_successfully_and_open_home_page() {
//		System.out.println("Logged in Sucessfully!");
//	}
//}
