package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		// driver.findElement(By.partialLinkText("Create new")).click();
		System.out.println("Clicked on 'Create New Account' button");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Manoj");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("manoj1123@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("5");
		driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("Jan");
		driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("1995");
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		driver.findElement(By.name("websubmit")).click();
		System.out.println("Registration form filled successfully.");
		Thread.sleep(1000);
		//driver.quit();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
