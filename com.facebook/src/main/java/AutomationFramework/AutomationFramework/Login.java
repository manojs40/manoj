package AutomationFramework;

import org.testng.annotations.Test;

public class Login {

	@Test(priority = 1)
	void Login_function() {
		System.out.println("Loging function");
	}

	@Test(priority = 2)
	void register_page() {

		System.out.println("register_page");

	}

	@Test(priority = 3)
	void forgot_password() {
		
		System.out.println("forgot_password");

	}

	@Test(priority = 4)
	void Index() {

		System.out.println("http:\\www.facebok.com");
	}

}
