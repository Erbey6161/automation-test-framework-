package tests;

import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.ExtentReportManager;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;

    @BeforeMethod
    public void setup() {

        // Report başlat
        extent = ExtentReportManager.getReport();

        // Driver setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // URL
        driver.get(ConfigReader.get("url"));

        System.out.println("TEST BAŞLADI");
    }

    @AfterMethod
    public void teardown() {

        // Report bitir
        extent.flush();

        // Browser kapat
        if (driver != null) {
            driver.quit();
        }

        System.out.println("TEST BİTTİ");
    }
}
