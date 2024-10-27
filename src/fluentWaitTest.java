import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class fluentWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("button")).click();
		
		
		  Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class); 

		
		
		WebElement success = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.id("finish")).isDisplayed()) {
					return driver.findElement(By.id("finish"));
				}
				return null;
			}
		});
		
		System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
		driver.quit();
		
		
		

	}

}
