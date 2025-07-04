package stepdefinitions;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;

public class ExtentReportHooks {

    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeAll
    public static void setup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario failed");
        } else {
            test.pass("Scenario passed");
        }
    }

    @AfterAll
    public static void tearDown() {
        extent.flush();
    }
}
