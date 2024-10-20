import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelfIntroduction {

	public static void main(String[] args) {
		//Invoking Browser
		// Chrom - ChromeDriver -> Methods
		//System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.yahoo.com");
		var correctTitle =  "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
		var title = driver.getTitle();
		var navUrl = driver.getCurrentUrl();
		System.out.println(title);
		System.out.println(navUrl);
		
		//driver.close();
		driver.quit();
	
	}

}
