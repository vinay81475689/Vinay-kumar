package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity5 {
	// Declare the object
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize the objects
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://training-support.net/webelements/simple-form");
	}

	@Test
	public void verifyPageTitle() {
		// Assert page title
		assertEquals(driver.getTitle(), "Selenium: Simple Form");
	}

	// Helper function to read Excel files
	public List<List<String>> readExcel(String filePath) throws InvalidFormatException, IOException {
		// List to store all the rows
		List<List<String>> data = new ArrayList<>();

		// File to read
		File inputFile = new File(filePath);
		// Create an object of workbook
		XSSFWorkbook workbook = new XSSFWorkbook(inputFile); // .xlsx
		// Select the sheet in the workbook
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		// Iterate through the rows and cells
		for (Row row : sheet) {
			// List to store the rows of the sheet
			List<String> innerRow = new ArrayList<>();
			for (Cell cell : row) {
				// Fetch cell values and add them to innerRow
				innerRow.add(cell.getStringCellValue());
			}
			// Add the innerRow to data
			data.add(innerRow);
		}
		// Close the file
		workbook.close();

		return data;
	}

	// DataProvider
	@DataProvider(name = "Users")
	public Object[][] params() throws InvalidFormatException, IOException {
		List<List<String>> data = new TestActivity5().readExcel("src/test/resources/users.xlsx");

		return new Object[][] { { data.get(1) }, { data.get(2) }, { data.get(3) } };
	}

	@Test(dataProvider = "Users")
	public void testSimpleForm(List<String> users) {
		// Find the input fields and enter text
		WebElement fullName = driver.findElement(By.id("full-name"));
		fullName.sendKeys(users.get(0));
		// Enter the email
		driver.findElement(By.id("email")).sendKeys(users.get(1));
		// Enter the Date of the event
		driver.findElement(By.name("event-date")).sendKeys(users.get(2).replaceAll("\"", ""));
		// Enter additional details
		driver.findElement(By.id("additional-details")).sendKeys(users.get(3));
		// Click Submit
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// Confirm booking
		String message = driver.findElement(By.id("action-confirmation")).getText();
		assertEquals(message, "Your event has been scheduled!");

		// Refresh the page
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}