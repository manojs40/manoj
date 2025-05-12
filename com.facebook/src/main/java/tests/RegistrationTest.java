package tests;

import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

	@Test
	public void testFacebookRegistration() {

		FacebookRegistrationPage regPage = new FacebookRegistrationPage(driver);
		regPage.clickSignUp();

		regPage.enterFirstName("Manoj");
		regPage.enterLastName("Kumar");
		regPage.enterEmail("manoj123@gmail.com");
		regPage.enterPassword("Test@12345");
		regPage.selectGender();
		regPage.clickSignUp();
		System.out.println("Registration Test Completed Successfully!");
	}
}