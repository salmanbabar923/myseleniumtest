package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedLocatorSteps {
    WebDriver driver;

    @Given("the browser is open")
    public void the_browser_is_open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("the user navigates to the shadow DOM page")
    public void navigate_to_shadow_dom_page() {
        driver.get("https://books-pwakit.appspot.com/");
    }

    @Then("the user interacts with the shadow element")
    public void interact_with_shadow_element() {
        // Get shadow root using JS
        WebElement host = driver.findElement(By.tagName("book-app"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", host);

        WebElement toolbar = shadowRoot1.findElement(By.cssSelector("app-header app-toolbar"));
        WebElement input = toolbar.findElement(By.cssSelector("book-input-decorator input"));
        input.sendKeys("Selenium");
    }

    @Then("the user interacts with element using dynamic xpath")
    public void interact_with_dynamic_xpath() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Example of dynamic xpath
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        if (!checkbox1.isSelected()) checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[position()=2]"));
        if (!checkbox2.isSelected()) checkbox2.click();

        driver.quit();
    }
}
