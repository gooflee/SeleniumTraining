import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;




public class SeleniumUSHover {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public SeleniumUSHover(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Main wait object for actions
        this.action = new Actions(driver);
    }

    public void testMethod() {
        // Accept cookies
        WebElement cookieAccept = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='cookieaccept']")));
        cookieAccept.click();

        // Perform hover until stability is detected
        performHoverWithStabilityCheck(By.cssSelector("a[class='mmlink']"));
    }

    private void performHoverWithStabilityCheck(By locator) {
        int maxAttempts = 5;  // Max retries for stability check
        boolean isStable = false;

        for (int attempt = 0; attempt < maxAttempts && !isStable; attempt++) {
            try {
                // Wait for element to be clickable and perform hover
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                action.moveToElement(element).perform();

                // Check stability: use WebDriverWait to verify element remains visible
                isStable = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(driver -> element.isDisplayed() && element.equals(driver.findElement(locator)));
                
                // If stable, break the loop
                if (isStable) break;

            } catch (StaleElementReferenceException e) {
                // Element became stale, indicating a refresh - retry the action
                System.out.println("Page refreshed, retrying hover...");
            }
        }

        if (!isStable) {
            throw new RuntimeException("Failed to maintain stable hover due to page redraw.");
        }
    }
}