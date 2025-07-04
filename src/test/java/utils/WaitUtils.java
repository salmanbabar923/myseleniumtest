package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {

    public static WebElement waitForElementVisible(WebDriver driver, By locator, int timeoutSeconds, int pollingMillis) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollingMillis))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);  // Keep this one

        return wait.until((Function<WebDriver, WebElement>) drv -> {
            WebElement element = drv.findElement(locator);
            return element.isDisplayed() ? element : null;
        });
    }
}
