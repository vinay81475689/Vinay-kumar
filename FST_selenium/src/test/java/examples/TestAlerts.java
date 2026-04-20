package examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAlerts {
	public static void main(String[] args) {
		// Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		try {
			// Open the page
			driver.get("https://training-support.net/webelements/alerts");
			// Verify the page title
			System.out.println(driver.getTitle());

			// Handle alerts
			new TestAlerts().handleSimpleAlert(driver);
			new TestAlerts().handleConfirmationAlert(driver);
			new TestAlerts().handlePromptAlert(driver);
	}
		finally {
			//Close the browser
			driver.quit();
	}
	}

	public void handleSimpleAlert(WebDriver driver) {
		// Click the button to trigger an alert
		driver.findElement(By.id("simple")).click();
		// Switch focus to the alert
		Alert simpleAlert = driver.switchTo().alert();
		// Print the alert message
		System.out.println(simpleAlert.getText());
		// Click OK on the alert
		simpleAlert.accept();

		// Print message
		System.out.println(driver.findElement(By.id("result")).getText());
	}

	public void handleConfirmationAlert(WebDriver driver) {
		// Click the button to trigger an alert
		driver.findElement(By.id("confirmation")).click();
		// Switch focus to the alert
		Alert confirmAlert = driver.switchTo().alert();
		// Print the alert message
		System.out.println(confirmAlert.getText());
		// Click OK on the alert
//		confirmAlert.accept();
		// Click Cancel on the alert
		confirmAlert.dismiss();

		// Print message
		System.out.println(driver.findElement(By.id("result")).getText());
	}

	public void handlePromptAlert(WebDriver driver) {
		// Click the button to trigger an alert
		driver.findElement(By.id("prompt")).click();
		// Switch focus to the alert
		Alert promptAlert = driver.switchTo().alert();
		// Print the alert message
		System.out.println(promptAlert.getText());
		// Type in the alert
		promptAlert.sendKeys("Hello");
		// Click OK on the alert
		promptAlert.accept();

		// Print message
		System.out.println(driver.findElement(By.id("result")).getText());
	}
}
