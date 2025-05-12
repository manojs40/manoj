package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterSteps {

	WebDriver driver;

	@Given("User is on Facebook login page")
	public void User_is() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		// Thread.sleep(1000);
		driver.manage().window().maximize();

	}

	@When("User enters valid username and password")
	public void User_enters() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("manoj@1234");
		// Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("Pass@123");
		Thread.sleep(1000);

	}

	@Then("Clicks on login button")
	public void Clicks() throws InterruptedException {
		driver.findElement(By.name("login")).click();
	}


}