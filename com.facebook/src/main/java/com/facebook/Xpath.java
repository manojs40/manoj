package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/?locale=in");

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("9999999999999999");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("0000000000000000");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000);

        driver.findElement(By.partialLinkText("Forgot Your Passwo")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("manoj@123");
		
		driver.findElement(By.name("continue")).click();
		// driver.quit();

	}

}
