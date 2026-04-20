package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Fixtures extends BaseClass {
	// Setup and teardown functions
	@BeforeAll
	public static void setp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}