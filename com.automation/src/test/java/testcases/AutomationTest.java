package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Report.ExtentReportManager1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AutomationTest {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;

	@BeforeSuite
	public void setUpReport() {
		extent = ExtentReportManager1.getInstance();
	}

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void openWebsiteAndValidateTitle() {
		test = extent.createTest("Open automationexercise.com");
		driver.get("https://www.automationexercise.com");
		String title = driver.getTitle();
		if (title.contains("Automation")) {
			test.log(Status.PASS, "Page opened and title verified");
		} else {
			test.log(Status.FAIL, "Title verification failed");
		}
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void flushReport() {
		extent.flush();
	}
}
