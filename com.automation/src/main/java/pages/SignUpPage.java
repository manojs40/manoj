package pages;
	
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class SignUpPage {
	    WebDriver driver;

	    @FindBy(xpath = "//input[@name='name']")
	    WebElement nameInput;

	    @FindBy(xpath = "//input[@data-qa='signup-email']")
	    WebElement emailInput;

	    @FindBy(xpath = "//button[text()='Signup']")
	    WebElement signupBtn;

	    @FindBy(xpath = "//a[@href='/']")
	    WebElement homeBtn;

	    public SignUpPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterName(String name) {
	        nameInput.sendKeys(name);
	    }

	    public void enterEmail(String email) {
	        emailInput.sendKeys(email);
	    }

	    public void clickSignUp() {
	        signupBtn.click();
	    }

	    public void clickHome() {
	        homeBtn.click();
	    }
	
	
	

}
