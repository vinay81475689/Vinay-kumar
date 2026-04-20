package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity567 {
	public static void main(String[] args) {
		// Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		try {
			// Open the page
			driver.get("https://training-support.net/webelements/dynamic-controls");
			// Verify the page title
			System.out.println(driver.getTitle());

			// Perform actions on the page
			new TestActivity567().testDisplayed(driver);
			new TestActivity567().testSelected(driver);
			new TestActivity567().testEnabled(driver);
		} finally {
			// Close the browser
			driver.quit();
		}
	}

	// Activity 5
	public void testDisplayed(WebDriver driver) {
		// Find the checkbox input element.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		// Check if it is visible on the page.
		System.out.println("Is the checkbox displayed? " + checkbox.isDisplayed());
		// Click the "Remove Checkbox" button.
		driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
		// Check if it is visible again and print the result
		System.out.println("Is the checkbox displayed? " + checkbox.isDisplayed());
	}

	// Activity 6
	public void testSelected(WebDriver driver) {
		// Find the checkbox input element.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		// Check if it is selected.
		System.out.println("Is the checkbox selected? " + checkbox.isSelected());
		// Click the checkbox element.
		checkbox.click();
		// Check if it is selected after clicking the input element.
		System.out.println("Is the checkbox selected? " + checkbox.isSelected());
	}

	// Activity 7
	public void testEnabled(WebDriver driver) {
		// Find the text field
		WebElement textField = driver.findElement(By.id("textInput"));
		// Check if the text field is enabled and print it.
		System.out.println("Is the text field enabled? " + textField.isEnabled());
		// Click the "Enable Input" button to enable the input field.
		driver.findElement(By.id("textInputButton")).click();
		// Check if the text field is enabled again and print it.
		System.out.println("Is the text field enabled? " + textField.isEnabled());
		textField.sendKeys("Test text");
		driver.findElement(By.id("textInputButton")).click();
		System.out.println("Text in the disabled field: " + textField.getDomProperty("value"));
	}
}
