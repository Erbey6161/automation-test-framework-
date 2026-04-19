package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {

        String path = System.getProperty("user.dir")
                + "/test-output/screenshots/"
                + testName + "_" + System.currentTimeMillis() + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
