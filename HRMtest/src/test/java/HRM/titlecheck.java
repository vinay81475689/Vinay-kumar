package HRM;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class titlecheck {
	// Declare the object
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize the objects
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://alchemy.hguy.co/orangehrm/\r\n");
	}

	@Test
	public void verifyPageTitle() {
		// Assert page title
		assertEquals(driver.getTitle(), "OrangeHRM");
	}



	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}