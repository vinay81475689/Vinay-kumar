package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestActivity16 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		try {
			
			driver.get("https://training-support.net/webelements/selects");
			//verify the title
			System.out.println(driver.getTitle());
			
			WebElement selectElem = driver.findElement(By.cssSelector("select.h-10"));
			Select dropdown = new Select(selectElem);
			dropdown.selectByVisibleText("One");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByValue("three");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByIndex(2);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			for (WebElement option : dropdown.getOptions()) {
				System.out.println(option.getText());
			}
		}
		finally {
			driver.quit(); 
			}	

	}

}
