package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import report.ExtentReportManager;

public class AutomationExerciseTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getReportInstance();
    }

    @BeforeTest
    public void setUp() {
       // System.setProperty("webdriver.chrome.driver", "path-to-your-chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openAutomationExerciseHomePage() {
        test = extent.createTest("Open AutomationExercise Home Page");
        driver.get("https://www.automationexercise.com");
        String title = driver.getTitle();
        if (title.contains("Automation")) {
            test.log(Status.PASS, "Website opened and title verified.");
        } else {
            test.log(Status.FAIL, "Website title did not match.");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void closeReport() {
        extent.flush();
    }
}

}
