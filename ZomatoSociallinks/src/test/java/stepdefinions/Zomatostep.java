package stepdefinions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Zomatostep {
	WebDriver driver;
	WebDriverWait wait;

	@Given("I am on the Zomato India home page")
	public void i_am_on_the_zomato_india_home_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.get("https://www.zomato.com/india");
	}

	@When("I click the {string} social link")
	public void i_click_the_social_link(String socialLink) {
		WebElement link = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[contains(@href,'" + socialLink.toLowerCase() + "')]")));
		link.click();
	}

	@Then("I should be redirected to {string}")
	public void i_should_be_redirected_to(String expectedUrl) {

		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		wait.until(ExpectedConditions.urlToBe(expectedUrl));
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		driver.quit();
	}
}