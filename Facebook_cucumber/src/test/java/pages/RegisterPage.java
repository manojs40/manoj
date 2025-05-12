package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstNameField = By.name("firstname");

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    @SuppressWarnings("deprecation")
	public String getFirstNameValue() {
        return driver.findElement(firstNameField).getAttribute("value");
    }
}
