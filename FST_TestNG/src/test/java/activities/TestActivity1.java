package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize the objects
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://training-support.net");
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// Assert page title
		assertEquals(driver.getTitle(), "Training Support");
	}

	@Test(priority = 2)
	public void testRedirect() {
		// Assert page heading
		driver.findElement(By.linkText("About Us")).click();
		wait.until(ExpectedConditions.urlContains("about"));
		assertEquals(driver.getTitle(), "About Training Support");
	}
	
	
		
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}


