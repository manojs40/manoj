package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='productinfo text-center']/p")
	List<WebElement> productNames;

	@FindBy(xpath = "//div[@class='productinfo text-center']/h2")
	List<WebElement> productPrices;

	@FindBy(xpath = "//div[@class='productinfo text-center']/p/following-sibling::a")
	List<WebElement> productViewButtons;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void printFirstFiveProductsDetails() throws InterruptedException {
		System.out.println("First 5 products details:");

		for (int i = 0; i < 5; i++) {
			String name = productNames.get(i).getText();
			String price = productPrices.get(i).getText();
			System.out.println((i + 1) + ". Product: " + name + " | Price: " + price);

		}

	}
}
