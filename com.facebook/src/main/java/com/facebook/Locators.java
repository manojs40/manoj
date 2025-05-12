package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		// driver.findElement(By.id("email")).sendKeys("email");
		driver.findElement(By.id("email")).sendKeys("manoj@122");
		Thread.sleep(2000); 
		driver.findElement(By.name("pass")).sendKeys("MAnoj");
		// Thread.sleep(2000);
		// driver.findElement(By.partialLinkText("Forgotten")).click();
		driver.findElement(By.partialLinkText("Create new ")).click();
		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname")).sendKeys("manoj");
		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).sendKeys("Shewale");
		driver.findElement(By.name("birthday_day")).click();
		driver.findElement(By.name("birthday_day")).sendKeys("25");
		driver.findElement(By.name("birthday_day")).click();
		// Thread.sleep(2000);
		driver.findElement(By.name("birthday_month")).click();
		driver.findElement(By.name("birthday_month")).sendKeys("Nov");
		driver.findElement(By.name("birthday_month")).click();
		// Thread.sleep(2000);
		driver.findElement(By.name("birthday_year")).click();
		driver.findElement(By.name("birthday_year")).sendKeys("1999");
		driver.findElement(By.name("birthday_year")).click();
		//driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.name("reg_email__")).click();
		driver.findElement(By.name("reg_email__")).sendKeys("84295968");

		driver.findElement(By.name("reg_passwd__")).click();
		driver.findElement(By.name("reg_passwd__")).sendKeys("321456987");
		driver.findElement(By.name("websubmit")).click();

       driver.quit();
	}

}
