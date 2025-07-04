package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.WaitUtils;

public class WaitFluent {

    WebDriver driver;

    @Given("the browser is open")
    public void the_browser_is_open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("the user navigates to dynamic loading page")
    public void navigate_to_dynamic_loading() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    @When("the user clicks the start button")
    public void click_start_button() {
        driver.findElement(By.cssSelector("#start button")).click();
    }

    @Then("wait until the Hello World message is visible")
    public void wait_for_message() {
        WebElement message = WaitUtils.waitForElementVisible(driver, By.id("finish"), 10, 500);
        System.out.println("Text is: " + message.getText());
        driver.quit();
    }
}
