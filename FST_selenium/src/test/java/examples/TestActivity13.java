package examples;

import java.time.Duration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity13 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		try {
			driver.get("https://training-support.net/webelements/tables");
			//verify the title
			System.out.println(driver.getTitle());
			
			
			List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			System.out.println("No. of columns: "+cols.size());
			System.out.println("No. of rows: "+ rows.size());
			String row3 = driver.findElement(By.xpath("//table/tbody/tr[3]")).getText();
			System.out.println(row3);
			String row2col2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
			System.out.println(row2col2);
		}
		finally {
			driver.quit(); 
			}

	}

}
