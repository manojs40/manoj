package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class ZomatoSteps {

    WebDriver driver;

    @Given("user is on the Zomato India page")
    public void user_is_on_zomato_india_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.zomato.com/india");
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String cityLink) {
        WebElement link = driver.findElement(By.linkText(cityLink));
        link.click();
    }

    @Then("user should be navigated to the Agra Restaurants page")
    public void user_should_be_on_agra_restaurants_page() {
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("Agra"));
        driver.quit();
    }
}
