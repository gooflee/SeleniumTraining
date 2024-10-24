import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class LocatorsPractice {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "rahul";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");		
		driver.findElement(By.id("inputUsername")).sendKeys("ChuckNorris");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		//driver.findElement(By.cssSelector("#container > div.form-container.sign-in-container > form > button")).click();
		driver.findElement(By.cssSelector("button.submit")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		System.out.println(driver.findElement(By.className("error")).getText());
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		//driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[1]")).sendKeys("ChuckNorris");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ChuckNorris");
		//driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[2]")).sendKeys("ChuckNorris@strongman.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ChuckNorris@strongman.com");
		//driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[3]")).sendKeys("555-555-5555");
		//driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("555-555-5555");
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("555-555-5555");
		//driver.findElement(By.className("reset-pwd-btn")).click();
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//System.out.println(driver.findElement(By.className("infoMsg")).getText());
		String errormesage = driver.findElement(By.cssSelector("form p")).getText();
		//System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		String[] errorToks = errormesage.split("'");
		System.out.println(errormesage + errorToks.length);
		//driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		

		Thread.sleep(1000);

		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);	
		
		//using regex
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(errorToks[1]);
		//driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
		Thread.sleep(1000);

		
		String loggedInMessage = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(loggedInMessage);
		Assert.assertEquals(loggedInMessage, "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Hello " + name +",", null);
		
		// Logout
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.quit();

	}
}