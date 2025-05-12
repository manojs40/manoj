package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.utils.ExcelUtils;

import java.time.Duration;

public class LoginTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		driver.manage().window().maximize();
		driver.get("https://www.automationexercise.com/login");
	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String email, String password) {
		WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));

		emailField.clear();
		passwordField.clear();

		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();

		try {
			WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			Assert.assertTrue(logoutButton.isDisplayed(), "Login Successful");
			System.out.println("Login successful for user: " + email);
		} catch (Exception e) {
			WebElement errorMessage = driver
					.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
			Assert.assertTrue(errorMessage.isDisplayed(), "Login Failed");
			System.out.println("Login failed for user: " + email);
		}
	}

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() {

		String excelPath = "C:\\Users\\GOVINDA COMP YEOLA\\OneDrive\\Desktop\\project\\com.automation\\src\\test\\resources\\shewale.xlsx";
		return ExcelUtils.getExcelData(excelPath, "Sheet1");
	}

	@AfterClass
	public void tearDown() {

		//driver.quit();
	}
}