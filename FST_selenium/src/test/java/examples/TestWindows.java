package examples;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWindows {
	public static void main(String[] args) {
		// Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			// Open the page
			driver.get("https://training-support.net/webelements/tabs");
			// Verify the page title
			System.out.println(driver.getTitle());

			// Store the handle of the current tab in a variable
			// This will help you find the newly opened tab later.
			String currentHandle = driver.getWindowHandle();
			System.out.println("Current active window: " + currentHandle);
			// Click on the button that opens a new page in another tab
			driver.findElement(By.xpath("//button[text()='Open A New Tab']")).click();
			// Wait until there's 2 tabs properly open
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			// Store the handles of all the open tabs in a variable.
			// Note: getWindowHandles() will always return a Set.
			Set<String> handles = driver.getWindowHandles();
			System.out.println("All open tabs: " + handles);
			// Loop through the Set and switch to the window
			// whose handle doesn't match the parentHandle
			for (String handle : handles) {
				driver.switchTo().window(handle);
			}
			// Print the handle of the new active tab
			currentHandle = driver.getWindowHandle();
			System.out.println("Current active window: " + currentHandle);
		} finally {
			// Close the browser
		driver.quit();
		}
	}
}