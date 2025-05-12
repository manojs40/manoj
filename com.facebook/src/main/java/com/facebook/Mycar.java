package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mycar {
	public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
     //   WebDriver.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.mycarhelpline.com/");

        // Maximize window
        driver.manage().window().maximize();

        // Example: Click on a menu option (replace with actual locator)
        WebElement menuOption = driver.findElement(By.linkText("Reviews"));
        menuOption.click();

        // Example: Search functionality (Modify the ID if different)
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Maruti Swift Review");
        searchBox.submit();
        Thread.sleep(3000);
        // Example: Click on a specific review link
        WebElement reviewLink = driver.findElement(By.partialLinkText("Maruti Swift"));
        reviewLink.click();
         driver.findElement(By.linkText("Swift Vs Grand i10 Nios")).click();
        // Wait for a few seconds (Explicit wait can be added for better handling)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close the browser
        driver.quit();
    }
}