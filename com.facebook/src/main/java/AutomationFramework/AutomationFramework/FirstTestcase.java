package AutomationFramework;

import org.testng.annotations.Test;

public class FirstTestcase {
	@Test(priority = 1)

	void Print_Hello() {

		System.out.println(" my fist Test case 1");
	}

	@Test(priority = 2)
	void Print_Index() {

		System.out.println("http:\\www.google.com");
	}

	
	@Test(priority = 3)
	void Print_Login() {
		
		System.out.println("my fist Test case no :-3");
		
	}
		@Test(priority = 4)
		void Print_Loginfacebook() {

			System.out.println("Facebook login page");
		

		

	}
}
//(dependsOnMethods = "")