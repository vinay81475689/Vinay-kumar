package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActivity10 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		Actions builder = new Actions(driver);
		try {
			driver.get("https://training-support.net/webelements/drag-drop");
			System.out.println(driver.getTitle());
			
			WebElement ball = driver.findElement(By.id("ball"));
			WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
			WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
			   List<WebElement> dropzoneTexts = driver.findElements(By.cssSelector("span.dropzone-text"));
			   
			builder.clickAndHold(ball).moveToElement(dropzone1).release().perform();
			System.out.println(dropzoneTexts.get(0).getText());
			builder.dragAndDrop(ball, dropzone2).perform();
			System.out.println(dropzoneTexts.get(1).getText());
			
		}finally {
			// Close the browser
			driver.quit();
		}

	}

}
