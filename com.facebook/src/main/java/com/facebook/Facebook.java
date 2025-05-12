package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Username/Emaile id");
		String un = sc.next();
		System.out.println("Please Enter Password");
		String pw = sc.next(); 

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");

		// driver.findElement(By.id("email")).sendKeys("email");
		driver.findElement(By.id("email")).sendKeys(un);
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys(pw);
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		// driver.close();

	}

}
