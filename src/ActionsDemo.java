import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.urbanscience.com/");
		
		WebDriverHelper helper = new WebDriverHelper(driver);
		Actions action = new Actions(driver);
		
		// Accept cookies
		driver.findElement(By.cssSelector("a[class='cookieaccept']")).click();
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement solutionMenu = driver.findElement(By.cssSelector("a[class='mmlink']"));
		//WebElement watchVideo = driver.findElement(By.xpath("//span[contains(text(),'WATCH')]"));
		WebElement watchVideo = driver.findElement(By.cssSelector("div.herocontent.a-down.a-opacity.a-active"));
		//WebElement contactExpert = driver.findElement(By.xpath("//span[text()='Contact an expert']"));
		WebElement contactExpert = driver.findElement(By.id("talk"));
		
		wait.until(d->ExpectedConditions.elementToBeClickable(watchVideo));
		wait.until(d->ExpectedConditions.elementToBeClickable(contactExpert));
		wait.until(d->ExpectedConditions.elementToBeClickable(watchVideo));
		helper.waitUntilDocumentIsReady(Duration.ofSeconds(10));
		wait.until(d->solutionMenu.isDisplayed());
		action.moveToElement(contactExpert).perform();
		action.moveToElement(solutionMenu).perform();
		
		
		
		
		
		driver.findElements(By.xpath("//a/strong[contains(text(),'NETWORK')]")).get(0).click();

	}
	

}
