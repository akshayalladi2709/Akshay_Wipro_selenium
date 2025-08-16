package testng_package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.ArrayList;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Ebay_testng {
    WebDriver driver;
    JavascriptExecutor jse;

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("userid")).sendKeys("fojewil395@aravites.com");
        driver.findElement(By.id("signin-continue-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pass")).sendKeys("987654a@");
        driver.findElement(By.id("sgnBt")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void multipleSearchTest() throws InterruptedException {
        ArrayList<String> items = new ArrayList<>();
        items.add("pen");
        items.add("shirts");
        items.add("table");
        for (String item : items) {
            WebElement sb = driver.findElement(By.id("gh-ac"));
            sb.clear();
            sb.sendKeys(item);
            sb.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }
    }

    @Test(priority = 3)
    public void addToCartTest() throws InterruptedException {
        WebElement sb = driver.findElement(By.id("gh-ac"));
        sb.clear();
        sb.sendKeys("Laptop");
        sb.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.get("https://www.ebay.com/itm/177334525191?_skw=Laptop&itmmeta=01K2HJR4D4Z8WHYYW8BJHB1CEZ&hash=item2949f61d07:g:e18AAeSwOXZom-VU&itmprp=enc%3AAQAKAAAA4FkggFvd1GGDu0w3yXCmi1dmzmyQc4QHy5Wqk73TYT8GtpLJo8wDB7kHk1HlNOTqWiekjOPKhFHH7uXwq%2BMkAsJtxNw1OXIGgIHZ25M0MONp%2FyuZXwttQkN%2BJXp0nf%2F9H4mLY4cmCy1HYuihVNv4TEBAW8jCeueAUFs0QY28pU%2FkX0DcosjXwcLxTXyhca%2BYmk5ZVWsvNcR9ESGtYLV94hg0pTNwhu7ob%2FGp1m%2FAPvC8BM2nheE9o47IwFxNkYC1YMFdMqdAIqsdDXd44Du1%2BnorjH49C4h3kGe698MPH9Kt%7Ctkp%3ABFBM-sbgspRm");
        Thread.sleep(3000);

        driver.findElement(By.id("atcBtn_btn_1")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void deleteFromCartTest() throws InterruptedException {
    	driver.get("https://cart.ebay.com/");
        driver.findElement(By.className("gh-cart__icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[data-test-id='cart-remove-item']")).click();
        Thread.sleep(2000);
    }


    @Test//(priority = 5)
    public void NameTest() throws InterruptedException {
        Actions act = new Actions(driver);
        Thread.sleep(3000);
        WebElement hiMsg = driver.findElement(By.cssSelector("span.gh-identity__greeting"));
        act.moveToElement(hiMsg).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='gh-identity-signed-in__link']/a[text()='Account settings']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("account-settings-link-PI")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("individual_personal_info_address_edit_button")).click();
        Thread.sleep(2000);
        
        WebElement fn = driver.findElement(By.id("firstname"));
        fn.clear();
        fn.sendKeys("aks");
        WebElement fn3 = driver.findElement(By.id("city"));
        fn3.clear();
        fn3.sendKeys("karimnagar");
        WebElement fn2 = driver.findElement(By.id("streetAddressOptional"));
        fn2.clear();
        fn2.sendKeys("hno:42");
        driver.findElement(By.id("address_edit_submit_button")).click();
        Thread.sleep(2000);   
        }



    @Test(priority = 7)
    public void shopByCategoriesTest() throws InterruptedException {
    	WebElement dropdown = driver.findElement(By.cssSelector("#gh-cat"));
        dropdown.click();
        Thread.sleep(1000);

      
        driver.findElement(By.cssSelector("#gh-cat option[value='267']")).click(); 

        Thread.sleep(3000);
        driver.findElement(By.id("gh-search-btn")).click();
    }
  @Test(priority = 9)
  public void shopByAllCategoriesTest() throws InterruptedException {
      driver.findElement(By.className("gh-categories__title")).click();
      Thread.sleep(2000);
      driver.findElement(By.className("gh-categories__col")).click();
      Thread.sleep(2000);
      Assert.assertTrue(driver.getTitle().contains("All Categories"));	
  }
    


    @Test(priority = 10)
	public void languageChange() throws InterruptedException {

		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

		WebElement country = driver.findElement(By.cssSelector("button[class=\"gf-flag__button\"]"));
		country.sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		driver.findElement(By.linkText("China")).click();

	}
    


    @BeforeTest
    public void beforeTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        jse = (JavascriptExecutor) driver;
    }

    @AfterTest
    public void afterTest() {
        Assert.assertTrue(true, "Test finished");
        //driver.quit();
    }
}
