package examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity12 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		try {
			driver.get("https://training-support.net/webelements/dynamic-content");
			   System.out.println(driver.getTitle());
			   
			   driver.findElement(By.id("genButton")).click();
			   
			   wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));
			   System.out.println(driver.findElement(By.id("word")).getText());
		}
		finally {
			// Close the browser
			driver.quit();
		}


	}

}
