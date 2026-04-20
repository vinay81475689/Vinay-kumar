package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends BaseClass {
	Alert alert;
	@Given("the user is on the Alerts page")
	public void openPage() {
		// Open the Alerts page
		driver.get("https://training-support.net/webelements/alerts");
		// Verify page title
		assertEquals(driver.getTitle(), "Selenium: Alerts");
	}
	
	@When("the user clicks on the {string} alert")
	public void openAlert(String alertType) {
		// Locate and click the button to trigger an alert
		switch(alertType) {
			case "simple":
				driver.findElement(By.id(alertType)).click();
			break;
			case "confirmation":
				driver.findElement(By.id(alertType)).click();
			break;
			case "prompt":
				driver.findElement(By.id(alertType)).click();
			break;
		}
	}
	
	@Then("an alert is visible")
	public void getAlert() {
		alert = driver.switchTo().alert();
	}
	
	@And("the user clicks the {string} button")
	public void handleAlert(String handler) {
		if(handler.equals("OK")) {
			// Handle the alert with OK
			alert.accept();
		} else {
			// Handle the alert with Cancel
			alert.dismiss();
		}
	}
	
	@And("the user types {string} in the prompt")
	public void typeTextInPrompt(String inputText) {
		// Type the text in the prompt
		alert.sendKeys(inputText);
	}
	
	@And("check if the message contains {string}")
	public void verifyAction(String messageContains) {
		// Read the message
		String message = driver.findElement(By.id("result")).getText();
		// Assertion
		assertTrue(message.contains(messageContains));
	}
}
