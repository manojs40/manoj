package AutomationFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {

	@BeforeMethod
	public void UserRegistration() {

		System.out.println("User is getting Registraction");
	}

	@Test(priority = 1)
	public void Userlogin() {

		System.out.println("User are able to login");

	}

	@Test(priority = 2)
	public void UserMoneyControl() {

		System.out.println("User is able to transfer funds to Another Account");

	}

	@AfterMethod
	public void UserLogout() {

		System.out.println("User are logout");

	}

}
