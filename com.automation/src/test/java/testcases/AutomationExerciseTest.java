package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExcelUtility;

public class AutomationExerciseTest {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		extent = Report.ExtentReportManager.getInstance();
	}

	@BeforeTest
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void openHomePageAndValidateTitle() {
		test = extent.createTest("Open AutomationExercise Home Page and Validate Title");
		driver.get("https://www.automationexercise.com");

		String actualTitle = driver.getTitle();
		test.log(Status.INFO, "Website opened successfully");
		test.log(Status.INFO, "Page title: " + actualTitle);

		if (actualTitle.contains("Automation")) {
			test.log(Status.PASS, "Title validation passed");
			ExcelUtility.writeTestResult("Homepage Title Validation", "PASS", "Title contains 'Automation'");
		} else {
			test.log(Status.FAIL, "Title validation failed");
			ExcelUtility.writeTestResult("Homepage Title Validation", "FAIL", "Incorrect title: " + actualTitle);
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		test.log(Status.INFO, "Browser closed");
	}

	@AfterSuite
	public void closeReport() {
		extent.flush();
	}
}
