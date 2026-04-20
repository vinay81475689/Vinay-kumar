package StepDefinations;
//
//import org.openqa.selenium.By;
//
//public class LoginSteps extends BaseClass{
//	@Given("the user is on the login page")
//	public void openPage() {
//	driver.get("https://training-support.net/webelements/login-form");	
//	assertEquals(driver.getTitle(),"Selenium: Login Form");
//    }
//	@When("they enter the Invalid username and password")
//	public void enterCredentials() {
//	WebElement username = driver.findElement(By.id("username"));
//	WebElement username = driver.findElement(By.id("password"));
//	
//	}
//	@And("click the submit button")
//	public void clickSubmit() {
//		
//	}
//	@Then("they are redirected to the login success page ")
//	public void verifySuccess() {
//		
//	}
//
//}


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends BaseClass {

    @Given("the user is on the login page")
    public void openPage() {
        driver.get("https://training-support.net/webelements/login-form");
        assertEquals("Selenium: Login Form", driver.getTitle());
    }

    @When("they enter the valid username and password")
    public void enterValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
    }

    @When("they enter the Invalid username and password")
    public void enterInvalidCredentials() {
        // Corrected duplicated variable names
        driver.findElement(By.id("username")).sendKeys("wrongUser");
        driver.findElement(By.id("password")).sendKeys("wrongPass");
    }

    @And("click the submit button")
    public void clickSubmit() {
        // Locating the submit button by its text
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    @Then("they are redirected to the login success page")
    public void verifySuccess() {
        // Wait for the URL to change or check for a success message
        wait.until(ExpectedConditions.urlContains("login-success"));
        String message = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Login Success", message);
    }

    @Then("the page displays an eoor message") // Matching the spelling mistake in your feature file
    public void verifyErrorMessage() {
        // Locate the error message element (usually has a specific ID or class)
        WebElement error = driver.findElement(By.id("action-confirmation")); 
        String errorText = error.getText();
        assertTrue(errorText.contains("Invalid"), "Error message should mention invalid credentials");
    }
}
