package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import java.time.Duration;

public class ZomatoStep {
	WebDriver driver;
	WebDriverWait wait;

	@Given("I am on the Zomato India home page")
	public void i_am_on_the_zomato_india_home_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zomato.com/agra");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("I click on the location field")
	public void i_click_on_the_location_field() {
		WebElement locationField = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@placeholder='Search for restaurant, cuisine or a dish']")));
		locationField.click();
	}

	@When("I type {string} in the location field")
	public void i_type_in_the_location_field(String city) {
		WebElement locationInput = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@placeholder='Search for restaurant, cuisine or a dish']")));
		locationInput.clear();
		locationInput.sendKeys(city);
	}

	@When("I select {string} from the dropdown")
	public void i_select_from_the_dropdown(String city) {
		WebElement cityOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'" + city + "')]")));
		cityOption.click();
		driver.quit();
	}

	@Then("I should be navigated to the {string} Zomato page")
	public void i_should_be_navigated_to_the_page(String city) {
		wait.until(ExpectedConditions.urlContains(city.toLowerCase()));
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.toLowerCase().contains(city.toLowerCase())) {
			System.out.println(" Successfully navigated to " + city + " page");
		} else {
			throw new AssertionError(" Failed! Current URL: " + currentUrl);
		}
	}

}
