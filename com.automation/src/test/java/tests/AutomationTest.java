package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import pages.ProductsPage;

public class AutomationTest extends BaseTest {

	@Test
	public void automationExerciseTest() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickSignUpLogin();
		Thread.sleep(2000);

		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.enterName("Manoj");
		signUpPage.enterEmail("manojtestauto@gmail.com");
		signUpPage.clickSignUp();

		// Here you can handle the next form page if needed or return back
		Thread.sleep(2000);
		signUpPage.clickHome();
		Thread.sleep(2000);

		home.clickProducts();
		Thread.sleep(2000);

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.printFirstFiveProductsDetails();
	}

}
