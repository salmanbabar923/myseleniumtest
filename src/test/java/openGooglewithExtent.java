import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class openGooglewithExtent {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setUpReport() {
        extent = ExtentReportManager.createReport();
    }

    @Test
    public void openGoogleTest() {
        test = extent.createTest("Google Test");

        // Setup and launch Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        test.info("Browser launched");

        // Open Google
        driver.get("https://www.google.com");
        test.pass("Opened Google successfully");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            test.info("Browser closed");
        }
        extent.flush();  // generate the report
    }
}
