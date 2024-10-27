import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {
	private WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilDocumentIsReady(Duration timeout) {
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        // Check if document is ready
        ExpectedCondition<Boolean> readyCondition = webDriver -> 
            (Boolean) javaScriptExecutor.executeScript(
                "return (document.readyState === 'complete' && (typeof jQuery === 'undefined' || jQuery.active === 0))"
            );
        wait.until(readyCondition);
    }
}
