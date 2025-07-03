package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver driver;

    @Step("Open browser")
    @Given("the browser is open")
    public void open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Step("Navigate to login page")
    @When("the user navigates to the login page")
    public void navigate_to_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Step("Check login page is displayed")
    @Then("the login page is displayed")
    public void validate_login_page() {
        String title = driver.getTitle();
        if (!title.contains("The Internet")) {
            throw new AssertionError("Login page not loaded.");
        }
        driver.quit();
    }
}
