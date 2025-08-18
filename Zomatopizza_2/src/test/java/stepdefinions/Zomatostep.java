package stepdefinions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.*;

public class Zomatostep {
	WebDriver driver;

	@Given("User launches the browser")
	public void user_launches_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User opens the Zomato India homepage")
	public void user_opens_the_zomato_india_homepage() {
		driver.get("https://www.zomato.com/india");
	}

	@When("User clicks on {string}")
	public void user_clicks_on(String cityName) {
		WebElement city = driver.findElement(By.linkText(cityName));
		city.click();
	}

	@When("User searches for {string} in the search bar")
	public void user_searches_for_in_the_search_bar(String foodItem) {
		WebElement searchBar = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("input[placeholder='Search for restaurant, cuisine or a dish']")));
		searchBar.sendKeys(foodItem);
		searchBar.sendKeys(Keys.ENTER);
	}

	@Then("Pizza search results should be displayed")
	public void pizza_search_results_should_be_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		boolean resultsFound = wait.until(d -> {
			try {
				String url = d.getCurrentUrl().toLowerCase();
				if (url.contains("pizza") || url.contains("q=") || url.contains("search")) {
					return true;
				}

				if (d.findElements(By.cssSelector("article")).size() > 0)
					return true;
				if (d.findElements(By.cssSelector("div[role='article'], div[role='listitem']")).size() > 0)
					return true;

				if (d.findElements(By.xpath("//*[contains(translate(text(),'PIZZA','pizza'),'pizza')]")).size() > 0)
					return true;

				return false;
			} catch (Exception e) {
				return false;
			}
		});

		assertTrue("Pizza results not found after search", resultsFound);

		driver.quit();
	}

}
