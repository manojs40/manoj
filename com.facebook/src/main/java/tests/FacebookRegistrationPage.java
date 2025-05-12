package tests;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class FacebookRegistrationPage {
		WebDriver driver;

		// Locators using @FindBy annotation
		@FindBy(name = "firstname")
		WebElement firstName;

		@FindBy(name = "lastname")
		WebElement lastName;

		@FindBy(name = "reg_email__")
		WebElement email;

		@FindBy(name = "reg_passwd__")
		WebElement password;

		@FindBy(name = "birthday_day")
		WebElement day;

		@FindBy(name = "birthday_month")
		WebElement month;

		@FindBy(name = "birthday_year")
		WebElement year;

		@FindBy(xpath = "//label[text()='Male']/preceding-sibling::input")
		WebElement maleGender;

		@FindBy(name = "websubmit")
		WebElement signUpButton;

		// Constructor to initialize elements
		public FacebookRegistrationPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		// Methods to perform actions
		public void enterFirstName(String fname) {
			firstName.sendKeys(fname);
		}

		public void enterLastName(String lname) {
			lastName.sendKeys(lname);
		}

		public void enterEmail(String emailID) {
			email.sendKeys(emailID);
		}

		public void enterPassword(String pass) {
			password.sendKeys(pass);
		}

		public void selectGender() {
			maleGender.click();
		}

		public void clickSignUp() {
			signUpButton.click();
		}
	}

	
	
	
	


