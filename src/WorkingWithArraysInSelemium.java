import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
public class WorkingWithArraysInSelemium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<String> vegatablesToSelect= Arrays.asList("Cucumber","Beans","Brinjal");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));


		//WebElement product = products.get(0);
		//List<WebElement> children = product.findElements(By.xpath(".//a"));
		//System.out.println(children.size());
		addItems(driver, vegatablesToSelect);
		
		driver.findElement(By.cssSelector(".cart-icon")).click();
		

		//driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[@class=' '][1]")).click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement applyButton = driver.findElement(By.cssSelector("button.promoBtn"));
		wait.until(d->applyButton.isDisplayed());

		// add promo
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		applyButton.click();
		
		WebElement discountApplied = driver.findElement(By.cssSelector("span.promoInfo"));
		
		// Checkout
		//List<WebElement> orderButtons = driver.findElements(By.xpath("//button")).get(2).click();
		wait.until(d->discountApplied.isDisplayed());
		 driver.findElements(By.xpath("//button")).get(1).click();
		
		//driver.quit();
	}
	public static void addItems(WebDriver driver, List<String> vegatablesToSelect) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> products = driver.findElements(By.cssSelector(".products .product"));
		
		  for(WebElement product : products) { 
			String productName = product.findElement(By.cssSelector(".product-name")).getText();
			for(String vegatable : vegatablesToSelect) {
			if(productName.contains(vegatable)) {
				WebElement incrementButton = product.findElement(By.xpath(".//a[@class='increment']"));

				int click = 0;
				while(click< 3) {
					incrementButton.click();
					//incrementButton.click();
					click++;
				}
				Thread.sleep(1000);
			  
			  //WebElement addToCart = product.findElement(By.xpath(".//button[text()='ADD TO CART']"));
			  //addToCart.click();
				
				// Add to Cart
				product.findElement(By.cssSelector(".product-action button")).click();
			} 
			  
		  }
		  
		 }
		 

	}
}
