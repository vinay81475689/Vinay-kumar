package StepDefinations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class define extends BaseClass {
	@Given("The user is on the login page")
	public void openPage() {
		// Open the login page
		driver.get("https://training-support.net/webelements/login-form");
		// Verify the page title
		assertEquals(driver.getTitle(), "Selenium: Login Form");
	}

	@When("they enter the valid username and password")
	public void enterValidCredentials() {
		// Locate username and password
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		// Clear the old values
		username.clear();
		password.clear();
		// Enter valid username
		username.sendKeys("admin");
		// Enter valid password
		password.sendKeys("password");
	}

	@When("they enter the invalid username and password")
	public void enterInvalidCredentials() {
		// Locate username and password
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		// Clear the old values
		username.clear();
		password.clear();
		// Enter valid username
		username.sendKeys("wrngAdmin");
		// Enter valid password
		password.sendKeys("WrognPassword");
	}

	@When("they enter {string} and {string}")
	public void enterCredentials(String username, String password) {
		// Locate username and password
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));

		// Clear the old values
		usernameField.clear();
		passwordField.clear();
		// Enter valid username
		usernameField.sendKeys(username);
		// Enter valid password
		passwordField.sendKeys(password);
	}

	@And("click the submit button")
	public void clickSubmit() {
		// Locate and click the submit button
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
	}

	@Then("they are redirected to the login success page")
	public void verifySuccess() {
		// Wait for page to load
		String h1message = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-emerald-500"))).getText();
		// Verify success message
		assertEquals(h1message, "Login Success!");
	}

	@Then("the page displays an error message")
	public void verifyFailure() {
		// Wait for error message
		String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
		// Verify success message
		assertEquals(errorMessage, "Invalid credentials");
	}
	
	@Then("the message displays {string}")
	public void verifyMessage(String expectedMessage) {
		String actualMessage;
		if(expectedMessage.contains("Invalid")) {
			// Wait for error message
			actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("subheading"))
			).getText();
		} else {
			// Wait for success message
			actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("h2.text-gray-800"))
			).getText();
		}
		// Verify success message
		assertEquals(actualMessage, expectedMessage);
	}
}
