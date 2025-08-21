package day_19;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		System.out.println("Welcome to Swag Labs");
		
		
		{
			System.out.println("check if User is able to sign in to website using correct credentials ");
		}
		
		driver.findElement(By.id("user-name")).click();
		driver.findElement(By.id("user-name")).sendKeys("user");
		
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("pass");
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		System.out.println("Login Successfully ");
		
		
		
		
		
	}
}
