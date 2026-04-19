package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {

            String path = ScreenshotUtil.takeScreenshot(
                    DriverFactory.getDriver(),
                    result.getName()
            );

            System.out.println("❌ TEST FAILED: " + result.getName());
            System.out.println("📸 Screenshot: " + path);
        }

        if (ITestResult.SUCCESS == result.getStatus()) {
            System.out.println("✅ TEST PASSED: " + result.getName());
        }

        if (ITestResult.SKIP == result.getStatus()) {
            System.out.println("⚠️ TEST SKIPPED: " + result.getName());
        }

        DriverFactory.quitDriver();
    }
}