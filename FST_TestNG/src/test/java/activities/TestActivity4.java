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

public class TestActivity4{
	// Declare the object
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize the objects
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://training-support.net/webelements/login-form");
	}

	@Test(priority=1)
	public void verifyPageTitle() {
		// Assert page title
		assertEquals(driver.getTitle(), "Selenium: Login Form");
	}
 @DataProvider(name="InvalidCreds")
 public Object[][] params(){
	 return new Object[][] {
		 {"wrongUsername","password"},
		 {"admin","wrongpassword"},
		 {"fakeUser","InvalidPassword"},
		 {"0_0" , ">.>"}
	 };
 }
	@Test(priority=2,dataProvider = "InvalidCreds")
	public void testInvalidLogin(String username, String password) {
	
		// Assertions
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
	    driver.findElement(By.id("subheading")).getText();
	   String message = driver.findElement(       )
		assertEquals(message,"Invalid credentials");
	}
	@Test(priority=3)
	public void testValidLogin() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		// Assertions
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	    driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800"))).getText();
		assertEquals(message,"Welcome Back, Admin!");
		
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
