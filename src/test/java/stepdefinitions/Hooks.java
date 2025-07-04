package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.ScreenshotUtils;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();
        DriverManager.setDriver(driver);

        if (scenario.isFailed() && driver != null) {
            ScreenshotUtils.captureScreenshot(driver, scenario.getName().replaceAll(" ", "_"));
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
