package day_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ActionClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/buttons");

		Actions act = new Actions(driver);

		WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
		act.doubleClick(doubleClick).perform();
		Thread.sleep(2000);

		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		act.contextClick(rightClick).perform();
		Thread.sleep(2000);

		WebElement singleClick = driver.findElement(By.xpath("//*[@id=\"uQTnU\"]"));
		singleClick.click();
		Thread.sleep(2000);

		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).perform();
		Thread.sleep(2000);

		driver.close();
	}
}