package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BlinkitStep {

	WebDriver driver;
	WebDriverWait wait;

	@Given("I am on the Blinkit home page")
	public void i_am_on_the_blinkit_home_page() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    driver.get("https://blinkit.com/");
	}


	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
	    WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Login')]")));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
	

	}
	@And("I enter mobile number {string}")
	//@When("I enter mobile number {string}")
	public void i_enter_mobile_number(String mobile) {
	    try {
	    	 {
	    	    WebElement mobileInput = wait.until(ExpectedConditions
	    	            .visibilityOfElementLocated(By.cssSelector("input[placeholder*='mobile']")));
	    	    mobileInput.clear();
	    	    mobileInput.sendKeys(mobile);
	    	}


	        // Wait for mobile input field directly (not modal)
	        WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("input[placeholder*='mobile']")
	        ));

	        mobileInput.clear();
	        mobileInput.sendKeys(mobile);

	    } catch (TimeoutException e) {
	        throw new AssertionError("❌ Mobile input field not found after clicking login. Locator may be wrong.");
	    } finally {
	        // Always return to main content if iframe was switched
	        try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
	    }
	}



	@And("I click on the Continue button")
	public void i_click_on_the_continue_button() {
	
		    WebElement continueButton = wait.until(ExpectedConditions
		            .elementToBeClickable(By.xpath("//button[contains(.,'Continue')]")));
		    continueButton.click();
		}



	@Then("I should see the OTP verification screen")
	public void i_should_see_the_otp_verification_screen() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("input[placeholder*='mobile']")
	    ));
	

		driver.quit();
	}
}
