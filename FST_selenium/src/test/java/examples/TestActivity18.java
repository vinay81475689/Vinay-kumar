package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestActivity18 {
	public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	try {
		driver.get("https://training-support.net/webelements/selects");
		//verify the title
		System.out.println(driver.getTitle());
	
		WebElement selectElem = driver.findElement(By.cssSelector("select.h-80"));
		Select multilist = new Select(selectElem);
		
		multilist.selectByVisibleText("HTML");
		multilist.selectByIndex(3);
		multilist.selectByIndex(4);
		multilist.selectByIndex(5);
		
		multilist.selectByValue("node.js");
		
		for(WebElement option : multilist.getAllSelectedOptions()) {
			System.out.println(option.getText());
		}
		multilist.deselectByIndex(4);
		
		for(WebElement option : multilist.getAllSelectedOptions()) {
			System.out.println(option.getText());
		}
	}
		finally {
			driver.quit();
		}
	}

}
