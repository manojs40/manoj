package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
public class mycar_com {
	
	public static WebDriver driver;
	
	//@BeforeTest
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mycarhelpline.com");
		driver.findElement(By.linkText("New Car")).click();
		driver.findElement(By.linkText("Reviews")).click();
	}
	
	

}
