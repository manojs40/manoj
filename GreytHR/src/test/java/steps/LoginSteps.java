package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the Greythr login page")
    public void the_user_is_on_the_greythr_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://openfuture.greythr.com/uas/portal/auth/login?login");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() throws InterruptedException {
        loginPage.enterUsername("AAG494");
        loginPage.enterPassword("Manoj@1994");
        Thread.sleep(5000);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() throws InterruptedException {
    	WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", loginButton);
    	
    	Thread.sleep(10000);
    }

    @Then("the user should be redirected to the dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        // Add validation for successful login here
        driver.quit();
    }
}