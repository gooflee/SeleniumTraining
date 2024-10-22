import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "bob";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("alertbtn")).click();
		//driver.findElement(By.cssSelector("[id='alertbtn"));
		
		String message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		
		message = driver.switchTo().alert().getText();
		System.out.println(message);
		driver.switchTo().alert().dismiss();
		
		driver.quit();
	}

}
