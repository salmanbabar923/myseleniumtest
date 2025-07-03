
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        test.pass("Opened Google successfully");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        extent.flush();  // this writes the report
    }
}
