package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelUtil;

import java.time.Duration;


public class RediffmailLoginTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		String excelPath = "C:\\Users\\GOVINDA COMP YEOLA\\OneDrive\\Desktop\\project\\com.automation\\src\\test\\resources\\shewale.xlsx";
		return ExcelUtil.readExcelData(excelPath, "Sheet1");
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String RediffmailID, String password) {
		
       
		WebElement emailField = driver.findElement(By.id("login1"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.name("proceed"));

		emailField.clear();
		emailField.sendKeys(RediffmailID);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginButton.click();

		System.out.println("Test executed for: " + RediffmailID);
	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
}
