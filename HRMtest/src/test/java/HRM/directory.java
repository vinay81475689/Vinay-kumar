package HRM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class directory {

	// Declare the object
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize the objects
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://alchemy.hguy.co/orangehrm/symfony/web/index.php/dashboard");
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		// Assert page title
		assertEquals(driver.getTitle(), "OrangeHRM");
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

	@Test(dependsOnMethods = {"checkValidCredentils"}, priority = 3)
	public void dashboard() {

		driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();

		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Apply Leave");

		// Select Leave Type → DayOff
		Select select = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		select.selectByVisibleText("DayOff");

		// Enter From Date
		WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
		fromDate.clear();
		fromDate.sendKeys("2026-01-20");

		// Enter To Date
		WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
		toDate.clear();
		toDate.sendKeys("2026-02-22");
		driver.findElement(By.id("applyBtn")).click();

		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		
		// Find from and to date fields
	    driver.findElement(By.id("calFromDate")).sendKeys("2026-01-20");
		// Enter the dates. Same as the above dates
		driver.findElement(By.id("calToDate")).sendKeys("2026-02-22");
		// Uncheck "All" and check "Pending Approval" checkbox
		WebElement checkbox = driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck"));
		if (checkbox.isSelected()) {
			checkbox.click();
		}
		driver.findElement(By.id("leaveList_chkSearchFilter_1")).click();

	

	}

	@Test(priority = 4)
	public void navigatetodirectory() {

		driver.findElement(By.id("menu_dashboard_index")).click();

		driver.findElement(By.id("menu_directory_viewDirectory")).click();

		assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Search Directory");
	}

	@Test(priority = 5)
	public void myinfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		assertEquals(driver.findElement(By.xpath("//h1[text()='Personal Details']")).getText(), "Personal Details");

		driver.findElement(By.xpath("//a[contains(@href,'viewQualifications')]")).click();

		assertEquals(driver.findElement(By.xpath("//h1[text()='Work Experience']")).getText(), "Work Experience");

		driver.findElement(By.id("addWorkExperience")).click();

		assertEquals(driver.findElement(By.id("headChangeWorkExperience")).getText(), "Add Work Experience");
		driver.findElement(By.id("experience_employer")).sendKeys("IBM");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
		driver.findElement(By.id("btnWorkExpSave")).click();
	}

	@Test(priority = 6)
	public void emergencycontactdetails() {

		driver.findElement(By.id("menu_pim_viewMyDetails")).click();

		driver.findElement(By.xpath("//a[contains(@href,'viewEmergencyContacts')]")).click();

		assertEquals(driver.findElement(By.xpath("//h1[text()='Assigned Emergency Contacts']")).getText(),
				"Assigned Emergency Contacts");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emgcontact_list']//tbody/tr"));

		for (WebElement row : rows) {

			List<WebElement> cols = row.findElements(By.tagName("td"));

			for (WebElement col : cols) {
				System.out.print(col.getText() + " | ");
			}

			System.out.println();
		}

	}

	@Test(priority = 6)

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}