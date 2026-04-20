package activities;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity3 {
// Declare the object
WebDriver driver;
WebDriverWait wait;

@BeforeClass(alwaysRun = true)
public void setUp() {
// Initialize the objects
driver = new FirefoxDriver();
wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Open the page
driver.get("https://training-support.net/webelements/target-practice");
}

@Test
public void verifyPageTitle() {
// Assert page title
	
assertEquals(driver.getTitle(), "Selenium: Target Practice ");
}

@Test(dependsOnMethods = {"verifyPageTitle"}, groups = {"Headers"})
public void headerTest1() {
// Assertions
	String thirdHeader = driver.findElement(By.cssSelector("h3.bold text-orange-600")).getText();
assertEquals(thirdHeader,"Heading #3");
}

@Test(dependsOnMethods = {"verifyPageTitle"}, groups = {"Headers"})
public void headerTest2() {
// Assertions
	String fifthColor = driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color");
assertEquals(Color.fromString(fifthColor).asHex(),"#9333ea");
}
@Test(dependsOnMethods = {"verifyPageTitle"}, groups = {"Buttons"})
public void headerTest3() {
String button=driver.findElement(By.css)
assertEquals();
}
@Test(dependsOnMethods = {"verifyPageTitle"}, groups = {"Headers"})
public void headerTest4() {
// Assertions
assertEquals();
}
@AfterClass
public void tearDown() {
// Close the browser
driver.quit();
}
}



