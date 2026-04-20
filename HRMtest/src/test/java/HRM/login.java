package HRM;



import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class login {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/orangehrm/symfony/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void checkInvalidCredentils() {
        driver.findElement(By.id("txtUsername")).sendKeys("Naveen");
        driver.findElement(By.id("txtPassword")).sendKeys("password123");
        driver.findElement(By.id("btnLogin")).click();

        String Errormessage = driver.findElement(By.id("spanMessage")).getText();
        assertEquals(Errormessage, "Invalid credentials");
    }

    @Test(priority = 2)
    public void checkValidCredentils() {

        // Clear previous inputs
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtPassword")).clear();

        // Enter correct credentials
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        String RedirectedPage = driver.findElement(By.id("menu_dashboard_index")).getText();
        assertEquals(RedirectedPage, "Dashboard");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}