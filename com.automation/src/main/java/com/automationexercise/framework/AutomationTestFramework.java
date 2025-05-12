
package com.automationexercise.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AutomationTestFramework {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginAndFetchProducts() throws InterruptedException {
        // Step 1: Open Website
        driver.get("https://www.automationexercise.com");
        Thread.sleep(2000);

        // Step 2: Click on Signup/Login
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        Thread.sleep(2000);

        // Step 3: Enter login details and submit
        driver.findElement(By.name("email"))
                .sendKeys("YOUR_EMAIL_HERE");
        driver.findElement(By.name("password"))
                .sendKeys("YOUR_PASSWORD_HERE");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(3000);

        // Step 4: Go to products page
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(3000);

        // Step 5: Get first 5 products
        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='productinfo text-center']/h2"));

        System.out.println("First 5 products and their prices:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". Product Name: " + productNames.get(i).getText());
            System.out.println("   Price: " + productPrices.get(i).getText());
        }
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

