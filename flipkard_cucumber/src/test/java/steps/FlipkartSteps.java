package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class FlipkartSteps {
	WebDriver driver;
	WebDriverWait wait;

	@Given("I launch the browser and open Flipkart website")
	public void openFlipkart() throws InterruptedException {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");

		try {
			WebElement closeBtn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'✕')]")));
			closeBtn.click();
		} catch (Exception e) {
			System.out.println("Login popup not displayed.");

		}
		driver.findElement(By.xpath("(//a[normalize-space()='Login'])[1]")).click();
		Thread.sleep(1000);

	}

	@When("I search for {string} in the search bar")
	public void searchForMobile(String query) {
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		searchBox.sendKeys(query);
	}

	@Then("I print all the search suggestions")
	public void printSuggestions() throws InterruptedException {

		Thread.sleep(2000);

		System.out.println("Suggestions:");
		WebElement Sug1 = driver.findElement(By.xpath("//div[@class='krHvwW']//li[1]"));
		WebElement Sug2 = driver.findElement(By.xpath("(//li[@class='AgOexi'])[3]"));
		WebElement Sug3 = driver.findElement(By.xpath("(//li[@class='AgOexi'])[4]"));
		WebElement Sug4 = driver.findElement(By.xpath("(//li[@class='AgOexi'])[5]"));
		WebElement Sug5 = driver.findElement(By.xpath("(//li[@class='AgOexi'])[6]"));
		WebElement Sug6 = driver.findElement(By.xpath("(//li[@class='AgOexi'])[7]"));
		WebElement Sug7 = driver.findElement(By.xpath("(//li[@class='AgOexi'])[8]"));

		System.out.println(Sug1.getText());
		System.out.println(Sug2.getText());
		System.out.println(Sug3.getText());
		System.out.println(Sug4.getText());
		System.out.println(Sug5.getText());
		System.out.println(Sug6.getText());
		System.out.println(Sug7.getText());

	}

	@And("I click on the first search suggestion")
	public void clickFirstSuggestion() throws InterruptedException {
		Thread.sleep(2000);

		WebElement  firstsuggestion = driver.findElement(By.xpath("//div[@class='krHvwW']//li[1]"));
		String firstsuggestionprint =  firstsuggestion.getText();
		System.out.println("i clicked on " + firstsuggestionprint);
		 firstsuggestion.click();
		Thread.sleep(1000);
		driver.quit();

	}

}
