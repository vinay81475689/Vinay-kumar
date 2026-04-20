package examples;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActivity8 {

	public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
   Actions builder = new Actions(driver);
   try {
	   driver.get("https://training-support.net/webelements/mouse-events");
	   System.out.println(driver.getTitle());
	   List<WebElement> buttons = driver.findElements(By.cssSelector("h1.svelte-hs12g9"));
	   WebElement cargoLock = buttons.get(0);
	   WebElement Cargotoml = buttons.get(1);
	   WebElement srcButton = buttons.get(2);
	   WebElement targetButton = buttons.get(3);
	   
//	   builder.click(cargoLock).moveToElement(Cargotoml).click().build().perform();
	
	   
	   builder.
	       doubleClick(srcButton).pause(2000). 
	       contextClick(targetButton).perform();
	     builder.click(driver.findElement(By.xpath("//span[text()='Open']"))).pause(2000).
	   build().perform();
	     
	     String message = driver.findElement(By.id("result")).getText();
		   System.out.println(message);
   }
   finally {
		driver.quit(); 
		}
   }
	}

