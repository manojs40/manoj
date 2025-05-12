package steps;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationSteps {

	WebDriver driver;

	@Given("I launch the browser and open the registration page")
	public void launchBrowserAndOpenRegistrationPage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

		
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));

	}

	@When("I enter first name as {string}")
	public void enterFirstName(String firstName) {
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstName);
	}
	

	@When("I enter last name as {string}")
	public void enterLastName(String lastName) {
		driver.findElement(By.xpath("(//body)[1]")).sendKeys(lastName);
	}

	@When("I select marital status as {string}")
	public void selectMaritalStatus(String status) {
		String xpath = "//input[@value='" + status.toLowerCase() + "']";
		driver.findElement(By.xpath(xpath)).click();
	}

	@When("I select hobbies as {string}")
	public void selectHobbies(String hobbies) {
		String[] hobbyList = hobbies.split(",");
		for (String hobby : hobbyList) {
			String trimmed = hobby.trim().toLowerCase();
			driver.findElement(By.xpath("//input[@value='" + trimmed + "']")).click();
		}
	}

	@When("I select country as {string}")
	public void selectCountry(String country) {
		new Select(driver.findElement(By.name("country"))).selectByVisibleText(country);
	}

	@When("I select DOB with month {string}, day {string}, year {string}")
	public void selectDOB(String month, String day, String year) {
		new Select(driver.findElement(By.name("month"))).selectByVisibleText(month);
		new Select(driver.findElement(By.name("day"))).selectByVisibleText(day);
		new Select(driver.findElement(By.name("year"))).selectByVisibleText(year);
	}

	@When("I enter phone number as {string}")
	public void enterPhoneNumber(String phone) {
		driver.findElement(By.name("phone")).sendKeys(phone);
	}

	@When("I enter username as {string}")
	public void enterUsername(String username) {
		driver.findElement(By.name("username")).sendKeys(username);
	}

	@When("I enter email as {string}")
	public void enterEmail(String email) {
		driver.findElement(By.name("email")).sendKeys(email);
	}

	@When("I upload profile picture from {string}")
	public void uploadProfilePicture(String filePath) {
		driver.findElement(By.name("profile_pic")).sendKeys(filePath);
	}

	@When("I enter about yourself as {string}")
	public void enterAboutYourself(String about) {
		driver.findElement(By.name("about")).sendKeys(about);
	}

	@When("I enter password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@When("I confirm password as {string}")
	public void confirmPassword(String confirmPassword) {
		driver.findElement(By.name("c_password")).sendKeys(confirmPassword);
	}

	@Then("I click the submit button")
	public void clickSubmitButton() {
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
}
