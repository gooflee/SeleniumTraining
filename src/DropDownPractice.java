import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//testStaticDropdown();
		//testUpdatedDropdown();
		// testDyamicDropdown();
		//testDyamicDropdownWithOutIndex();
		//testAutoSuggest();
		//checkboxPractice();
		//calendarPractice();
		checkIfDisabled();
	}
	
	private static void testStaticDropdown()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		// static Dropdown
		
		
	
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.quit();
	}
	
	private static void testUpdatedDropdown()
	{
		int numberOfClicks = 5;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("divpaxinfo")).click();

		int click = 1;
		while(click<numberOfClicks) {
			driver.findElement(By.id("hrefIncAdt")).click();
			click++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
			
		
		driver.quit();
	}
	
	private static void testDyamicDropdown()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='DEL']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='PAT'])[2]")).click();
		
		// For CSS selector this is the only way for it to work
		//driver.findElements(By.cssSelector("a[value='PAT']")).get(1).click();
			
		
		driver.quit();
	}
	private static void testDyamicDropdownWithOutIndex() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='DEL']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PAT']")).click();
		
		// For CSS selector this is the only way for it to work
		//driver.findElements(By.cssSelector("a[value='PAT']")).get(1).click();
			
		
		driver.quit();
	}
	
	private static void testAutoSuggest() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("autosuggest")).sendKeys("Rus");
	
		Thread.sleep(2000);
		List<WebElement> listOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option :listOptions) 
		{
			if(option.getText().equalsIgnoreCase("Russian Federation"))
			{
				option.click();
				break;
			}
		}
		
		//driver.findElement(By.linkText("Russian Federation")).click();
		
		
		
		driver.quit();
	
	}
	
	private static void checkboxPractice() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id*='friendsandfamily'")).isSelected(), true);
	
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Number of checks "+ checkBoxes.size());
		
		driver.quit();
	
	}
	
	private static void calendarPractice() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("div[class='picker-first2'] button")).click();

		driver.quit();
	
	}
	private static void checkIfDisabled() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		// This is not working in modern web technology
		//Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		boolean elemeentEnabled = false;
		if(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("opacity: 1"))
		{
			elemeentEnabled = true;
		}
		System.out.println(elemeentEnabled);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("opacity: 1"))
		{
			elemeentEnabled = true;
		}
		System.out.println(elemeentEnabled);
		//driver.findElement(By.cssSelector("div[class='picker-first2'] button")).click();


		driver.quit();
	
	}
	
}
