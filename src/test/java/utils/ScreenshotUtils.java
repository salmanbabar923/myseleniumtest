package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String path = "screenshots/" + screenshotName + "_" + UUID.randomUUID() + ".png";
            File dest = new File(path);
            FileUtils.copyFile(src, dest);

            // Attach to Allure
            Allure.addAttachment(screenshotName, new ByteArrayInputStream(FileUtils.readFileToByteArray(dest)));

            System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
        }
    }
}
