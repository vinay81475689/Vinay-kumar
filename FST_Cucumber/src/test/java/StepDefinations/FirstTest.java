package StepDefinations;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstTest extends BaseClass{
	@Given("the user is on the TS homepage")
    public void openPage() {
		driver.get("https://training-support.net");
		assertEquals(driver.getTitle(), "Training Support");
	}
//	private void assertEquals(@Nullable String title, String string) {
//		// TODO Auto-generated method stub
//		
//	}
	@When("the user click the About Us link")
	  public void clickAbout() {
		driver.findElement(By.linkText("About Us")).click();
	}
	@Then("the user is redirected to the About page")
	  public void verifyRedirect()
	  {
		wait.until(ExpectedConditions.urlContains("about"));
		assertEquals(driver.getTitle(), "About Training Support");
	  }
}
