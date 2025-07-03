import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;

public class  driverSetupTestNG {

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setUpReport() {
        extent = ExtentReportManager.getReportInstance();
    }


public class driverSetupTest{
    WebDriver driver;

    @BeforeMethod
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

    }

    @Test
    public void opentheGooglePage(){
        driver.get("https://www.google.com");
        System.out.println("Title:" + driver.getTitle());

    }

    @AfterMethod
    public void closethedriver(){
        driver.quit();
    }

    public class MyTest {
        Logger logger= LoggerFactory.getLogger(Logger.class);
        public void runTest(){
            logger.info("Test Started");
        }

    }
    @AfterSuite
    public void flushReport() {
        extent.flush();
    }

}
}
