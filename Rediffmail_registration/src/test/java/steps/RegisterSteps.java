package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterSteps {
    WebDriver driver;

    @Given("I launch the Chrome browser")
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I open the Rediffmail registration page")
    public void openRegistrationPage() {
        driver.get("https://register.rediff.com/register/register.php");
    }

    @When("I enter first name as {string}")
    public void enterFirstName(String fname) {
        driver.findElement(By.name("name")).sendKeys(fname);
    }

    @When("I enter email ID as {string}")
    public void enterEmail(String email) {
        driver.findElement(By.name("login")).sendKeys(email);
    }

    @When("I enter password as {string}")
    public void enterPassword(String pwd) {
        driver.findElement(By.id("newpasswd")).sendKeys(pwd);
    }

    @When("I re-enter password as {string}")
    public void reEnterPassword(String pwd2) {
        driver.findElement(By.id("newpasswd1")).sendKeys(pwd2);
    }

    @When("I enter alternate email as {string}")
    public void enterAltEmail(String altEmail) {
        driver.findElement(By.name("altemail")).sendKeys(altEmail);
    }

    @When("I select day as {string}, month as {string}, and year as {string}")
    public void selectDOB(String day, String month, String year) {
        new Select(driver.findElement(By.name("DOB_Day"))).selectByVisibleText(day);
        new Select(driver.findElement(By.name("DOB_Month"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("DOB_Year"))).selectByVisibleText(year);
    }

    @When("I select gender as {string}")
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            driver.findElement(By.xpath("//input[@value='m']")).click();
        } else {
            driver.findElement(By.xpath("//input[@value='f']")).click();
        }
    }

    @When("I enter mobile number as {string}")
    public void enterMobile(String mobile) {
        driver.findElement(By.name("mobno")).sendKeys(mobile);
    }

    @Then("I click on the Create My Account button")
    public void clickSubmit() {
        driver.findElement(By.name("Register")).click();
    }
}
