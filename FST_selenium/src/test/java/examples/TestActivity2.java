package examples;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity2 {
	public static void main(String[] args) {
		
		//initialize the object
		WebDriver driver = new FirefoxDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		try {
			//open the page
			driver.get("https://training-support.net/webelements/login-form");
			//verify the title
			System.out.println(driver.getTitle());
			//locate the username field and type in the valid username
			driver.findElement(By.id("username")).sendKeys("admin");
			//locate the password field and type in the valid password
			driver.findElement(By.id("password")).sendKeys("password");
			//locate the submit button
			driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
			String h1message = driver.findElement(By.cssSelector("h1.text-emerald-500")).getText();
			String h2message = driver.findElement(By.cssSelector("h2.text-gray-800")).getText();
			System.out.println(h1message);
			System.out.println(h2message);
		}
		finally {
			driver.quit();
			}
	}
	}
