package stepdefinitions;
 
import java.time.Duration;
import java.util.Scanner;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.cucumber.java.en.*;
 
public class loginstep {
	WebDriver driver;
	@Given("User is on Zomato login page for search pizza")
	public void zomato_login() throws InterruptedException {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.zomato.com/india");
        Thread.sleep(2000);

        WebElement Login_Button = driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
        Login_Button.click();
        Thread.sleep(2000);
	}

    @When("User enters valid Email")
    public void enter_Email () throws InterruptedException {

    	Thread.sleep(5000);
    	WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='auth-login-ui']"));
    	driver.switchTo().frame(iframe1);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement emailBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
    	    By.xpath("//div[@aria-label='Continue with Email']")
    	));
 
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", emailBtn);

    }
    @When("User send otp for search pizza")
    public void User_send_otp () throws InterruptedException {

    	Thread.sleep(2000);
    	WebElement emailField = driver.findElement(By.cssSelector("input[type='text']"));
    	emailField.sendKeys("manojshewale0007@gmail.com");

    	driver.findElement(By.xpath("//button[contains(., 'Send One Time Password')]")).click();
    }
    @And("User Verify the otp for pizza")
    public void verify_otp () throws InterruptedException {

    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter OTP: ");
        String otp = scanner.nextLine();
        scanner.close();
 
       
        for (int i = 0; i < otp.length(); i++) {
            String xpath = "(//input[@type='text' and @maxlength='2'])[" + (i + 1) + "]";
            WebElement otpBox = driver.findElement(By.xpath(xpath));
            otpBox.sendKeys(String.valueOf(otp.charAt(i)));} 
            Thread.sleep(2000);
            driver.switchTo().defaultContent();	
            Thread.sleep(5000);
    }
    @Then("User have login and set current location")
    public void successfully_login () throws InterruptedException {

    	WebElement abdresto = driver.findElement(By.xpath("//h5[normalize-space()='Aurangabad Restaurants']"));
    	abdresto.click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[@placeholder='Aurangabad']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//p[text()='Detect current location']")).click();
    }
    @When("User search pizza in search bar")
    public void user_search () throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for restaurant, cuisine or a dish']"));
    	search.click();
    	search.sendKeys("Pizza - Delivery");
    	search.click();
    	Thread.sleep(2000);
    }
    @Then("User select first restaurant")
    public void select_restaurant () throws InterruptedException {
    	driver.findElement(By.xpath("(//img[@alt='Restaurant Card'])[1]")).click();
    	Thread.sleep(2000);
    	//driver.quit();
    }

}