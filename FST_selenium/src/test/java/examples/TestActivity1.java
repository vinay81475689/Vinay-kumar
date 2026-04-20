package examples;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestActivity1 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new FirefoxDriver();
		
		try {
		driver.get("https://training-support.net/");
		System.out.println(driver.getTitle());
		
	    driver.findElement(By.className("svelte-4bhb3l")).click();
		driver.findElement(By.cssSelector("a.svelte-4bhb3l")).click();
        driver.findElement(By.linkText("About Us")).click();
		
		System.out.println(driver.getTitle());
		}
		
		finally {
		driver.quit();
		}
		
	}

}
